package com.automation.fb;

import static org.testng.Assert.assertEquals;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.CommonUtilities;

public class FBTestCase
{
    WebDriver driver;
    Properties prop;

    @BeforeClass
    public void getSystemProperties() throws Exception
    {
        System.setProperty( "webdriver.chrome.driver",
                            "C:\\\\Users\\\\sachitan\\\\Desktop\\\\chromedriver_win32\\\\chromedriver.exe" );
        this.driver = CommonUtilities.driver;
        this.prop = CommonUtilities.prop;
    }

    @AfterMethod
    public void kilBrowser()
    {
        CommonUtilities.killBrowser();
    }

    @Test
    public void facebookTest() throws Exception
    {
        try
        {
            FacebookLogin fbLogin = new FacebookLogin( driver );
            fbLogin.loginToFB( prop.getProperty( "fbuserId" ), prop.getProperty( "fbpassword" ) );

            FacebookProfile profile = new FacebookProfile( driver );
            String status = profile.updateStatus( "Hello World" );

            assertEquals( status, "Hello World" );
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
            Assert.fail( "Test Case Failed" );
        }
    }
}