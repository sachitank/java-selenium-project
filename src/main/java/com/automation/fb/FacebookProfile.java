package com.automation.fb;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.ActionUlitilties;
import com.automation.CommonUtilities;

public class FacebookProfile
{
    WebDriver driver;

    public FacebookProfile( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    @FindBy( xpath = "//span[text()='Sachi T']" )
    private WebElement profileName;

    @FindBy( xpath = "//div[text()='Edit']" )
    private WebElement editProfile;

    @FindBy( xpath = "//textarea[@placeholder='Describe who you are']" )
    private WebElement updateStatus;

    @FindBy( xpath = "//span[text()='Save']" )
    private WebElement saveStatus;

    @FindBy( xpath = "//textarea[text()='Hello World']" )
    private WebElement getStatusUpdated;

    private By clearEditBox = By.xpath( "//textarea[@placeholder='Describe who you are']" );

    private void navigateToProfilePage()
    {
        profileName.click();
    }

    private void editProfile()
    {
        editProfile.click();
    }

    private void writeStatus( String status ) throws Exception
    {
        try
        {
            CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), updateStatus );
            ActionUlitilties.clearText( clearEditBox );
            updateStatus.click();
            updateStatus.clear();
            updateStatus.sendKeys( status );
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }

    private void saveStatus()
    {
        saveStatus.click();
    }

    public String updateStatus( String status ) throws Exception
    {
        try
        {
            navigateToProfilePage();
            CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), editProfile );

            editProfile();
            writeStatus( status );
            saveStatus();
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
        return updateStatus.getText();
    }
}
