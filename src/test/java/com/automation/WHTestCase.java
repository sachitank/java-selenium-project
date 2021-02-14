package com.automation;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WHTestCase
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
    public void walletHubTest() throws Exception
    {
        try
        {
            Login login = new Login( driver );
            login.loginToWalletHub( "sachi.tank@live.com", "Hub@2020" );

            TestInsuranceCompany test = new TestInsuranceCompany( driver );
            test.rate( 4 );

            Review review = new Review( driver );
            review.writeReviewForHealthInsurance( "C:\\Sachi\\Project_Learn\\automation\\review.txt" );

            Profile profile = new Profile( driver );
            profile.navigateToUserProfile();

            String recommend = driver.findElement( By.xpath( "// h2[text()='I RECOMMEND']" ) ).getText();

            assertEquals( recommend, "I RECOMMEND" );
            System.out.println( "Test Case Pass" );
        }
        catch( Exception ex )
        {
            System.out.println( "Test Case Fali" );
        }
    }
}