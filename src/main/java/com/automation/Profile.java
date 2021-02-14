package com.automation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Profile
{
    WebDriver driver;

    @FindBy( xpath = "//nav[@class = 'dd']/ul/li/a[text()='Profile']" )
    private WebElement userProfile;

    @FindBy( css = "a[class=user]" )
    private WebElement userName;

    public Profile( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    public void navigateToUserProfile()
    {
        try
        {
            CommonUtilities.navigateToUrl( "https://wallethub.com/profile/" );
            CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), userName );
            ActionUlitilties.hoverMouse( userName );
            ActionUlitilties.hoverAndSelectOption( userProfile );
            userProfile.click();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}