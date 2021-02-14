package com.automation.fb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import com.automation.CommonUtilities;

public class FacebookLogin
{
    WebDriver driver;

    public FacebookLogin( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    @FindBy( id = "email" )
    private WebElement userIdElement;

    @FindBy( id = "pass" )
    private WebElement passwordElement;

    @FindBy( css = "button[name=login]" )
    private WebElement loginButtonElement;

    @FindBy( xpath = "//span[text()='Sachi T']" )
    private WebElement profileName;

    public void navigateToFBLoginPage()
    {
        CommonUtilities.navigateToUrl( CommonUtilities.prop.getProperty( "fbUrl" ) );
    }

    public void enterUserName( String userId )
    {
        userIdElement.sendKeys( userId );
    }

    public void enterPassword( String password )
    {
        passwordElement.sendKeys( password );
    }

    public void clickLoginButton()
    {
        loginButtonElement.click();
    }

    public void loginToFB( String userId, String password )
    {
        try
        {
            CommonUtilities.maximizeBrowser();
            navigateToFBLoginPage();

            enterUserName( userId );
            enterPassword( password );
            clickLoginButton();

            CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), profileName );

            if( profileName.isDisplayed() )
            {
                System.out.println( "User " + userId + " Logged In Successfully." );
            }
            else
            {
                System.out.println( "User " + userId + " Login Failed" );
            }
        }
        catch( Exception e )
        {
            System.out.println( "User " + userId + " Login Failed" );
            e.printStackTrace();
        }
    }
}
