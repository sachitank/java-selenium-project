package com.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtilities
{
    private static ChromeOptions options = disableChormeOptions();
    public static WebDriver driver = new ChromeDriver( options );
    public static WebDriverWait wait = new WebDriverWait( driver, 3 );
    public static Properties prop = readPropertiesFile();

    public CommonUtilities( WebDriver driver )
    {
        CommonUtilities.driver = driver;
    }

    public static void waitUntilElementToBeClickable( Duration timeOut, WebElement element )
    {
        try
        {
            wait.withTimeout( timeOut );
            wait.until( ExpectedConditions.elementToBeClickable( element ) );
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
    }

    public static String readTextFile( String filePath ) throws IOException
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            File file = new File( filePath );
            BufferedReader br = new BufferedReader( new FileReader( file ) );

            String st;

            while( ( st = br.readLine() ) != null )
            {
                builder.append( st );
            }
        }
        catch( Exception ex )
        {
            ex.getMessage();
        }
        return builder.toString();
    }

    public static void navigateToUrl( String url )
    {
        driver.get( url );
    }

    public static void maximizeBrowser()
    {
        driver.manage().window().maximize();
    }

    public static Properties readPropertiesFile()
    {
        File file = new File( "C:\\Sachi\\Project_Learn\\automation\\src\\main\\java\\cofig.properties" );

        prop = new Properties();

        FileInputStream fileInput = null;
        try
        {
            fileInput = new FileInputStream( file );
        }
        catch( FileNotFoundException e )
        {
            e.printStackTrace();
        }
        try
        {
            CommonUtilities.prop.load( fileInput );
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
        return CommonUtilities.prop;
    }

    public static void killBrowser()
    {
        driver.quit();
    }

    private static ChromeOptions disableChormeOptions()
    {
        ChromeOptions options = new ChromeOptions();
        try
        {
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put( "profile.default_content_setting_values.notifications", 2 );
            options.setExperimentalOption( "prefs", prefs );
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return options;
    }
}