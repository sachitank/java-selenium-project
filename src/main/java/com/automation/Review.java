package com.automation;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Review
{
    WebDriver driver;

    public Review( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    @FindBy( xpath = "//div[@class='wrev-user-input-box input-field progress-indicator-container']/ng-dropdown/div/span" )
    private WebElement dropDown;

    @FindBy( css = "textarea[placeholder='Write your review...']" )
    private WebElement writeReview;

    @FindBy( xpath = "//ul[@class='dropdown-list ng-enter-element']/li[text()='Health Insurance']" )
    private WebElement optionXpth;

    @FindBy( css = "div[class='sbn-action semi-bold-font btn fixed-w-c tall']" )
    private WebElement submit;

    public void writeReviewForHealthInsurance( String filePath ) throws Exception
    {
        String text = "";

        try
        {
            text = CommonUtilities.readTextFile( filePath );
            dropDown.click();
            optionXpth.click();
            writeReview.sendKeys( text );
            submit.click();
        }
        catch( IOException e )
        {
            e.printStackTrace();
        }
    }
}