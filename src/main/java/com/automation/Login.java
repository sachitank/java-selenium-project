package com.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login
{
    WebDriver driver;

    public Login( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    @FindBy( id = "email" )
    private WebElement userIdElement;

    @FindBy( id = "password" )
    private WebElement passwordElement;

    @FindBy( xpath = "//span[text()='Login']" )
    private WebElement loginButtonElement;

    @FindBy( className = "profile-name" )
    private WebElement profileName;

    private void navigateToWalletHubLoginPage()
    {
        CommonUtilities.navigateToUrl( "https://wallethub.com/login" );
    }

    private void enterUserName( String userId )
    {
        userIdElement.sendKeys( userId );
    }

    private void enterPassword( String password )
    {
        passwordElement.sendKeys( password );
    }

    private void clickLoginButton()
    {
        loginButtonElement.click();
    }

    public void loginToWalletHub( String userId, String password ) throws Exception
    {
        try
        {
            CommonUtilities.maximizeBrowser();

            navigateToWalletHubLoginPage();
            CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), userIdElement );

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