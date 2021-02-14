package com.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUlitilties
{
    static WebDriver driver = CommonUtilities.driver;
    static Actions actions = new Actions( driver );

    public static void hoverMouse( WebElement element )
    {
        actions.moveToElement( element ).build().perform();
    }

    public static void hoverAndClickElements( WebDriver driver, List<WebElement> elements, int elementToBeClicked )
        throws Exception
    {
        try
        {
            actions.moveToElement( elements.get( elementToBeClicked - 1 ) ).build().perform();
            actions.click().click( elements.get( elementToBeClicked - 1 ) ).build().perform();
        }
        catch( org.openqa.selenium.StaleElementReferenceException ex )
        {
            ex.printStackTrace();
        }
    }

    public static void hoverAndSelectOption( WebElement element )
    {
        actions.click().moveToElement( element ).keyDown( Keys.SHIFT ).click().build().perform();
    }

    public static void clearText( By clearEditBox ) throws Exception
    {
        try
        {
            WebElement toClear = driver.findElement( clearEditBox );
            toClear.sendKeys( Keys.CONTROL + "a" );
            toClear.sendKeys( Keys.DELETE );
        }
        catch( Exception ex )
        {
            ex.printStackTrace();
        }
    }
}
