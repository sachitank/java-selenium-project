package com.automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestInsuranceCompany
{
    WebDriver driver;

    By stars = By.xpath( "//*[name()='svg']/*[name()='g']/*[name()='path'][starts-with(@d, 'M6')]" );

    @FindBy( xpath = "//*[name()='svg']/*[name()='g']/*[name()='path'][starts-with(@d, 'M6')]" )
    private WebElement star;

    public TestInsuranceCompany( WebDriver driver )
    {
        this.driver = driver;
        PageFactory.initElements( this.driver, this );
    }

    public void navigateToTestInsuranceCompany()
    {
        CommonUtilities.navigateToUrl( "http://wallethub.com/profile/test_insurance_company/" );
    }

    public void rate( int rating ) throws Exception
    {
        navigateToTestInsuranceCompany();
        CommonUtilities.waitUntilElementToBeClickable( Duration.ofSeconds( 3 ), star );

        List<WebElement> we = driver.findElements( stars );
        ActionUlitilties.hoverAndClickElements( driver, we, rating );
    }
}
