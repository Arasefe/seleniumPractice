package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC2_PracticeCyberTek_AddRemoveElements {
    // 1. Open Chrome browser
    // 2. Go to http://practice.cybertekschool.com/add_remove_elements/
    // 3. Click to “Add Element” button
    // 4. Verify “Delete” button is displayed after clicking.
    // 5. Click to “Delete” button.
    // 6. Verify “Delete” button is NOT displayed after clicking.
    WebDriver driver;

    @BeforeMethod
    public void setUp(){

        driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");
        BrowserUtilities.wait(2);
    }
    @Test
    public void tc2_practiceCyberTek_AddRemoveElements(){

        WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();
        BrowserUtilities.wait(3);

        WebElement deleteButton=driver.findElement(By.xpath("//div[@id='elements']/button"));
        Assert.assertTrue(deleteButton.isDisplayed(),"Delete button is not displayed!!!");

        deleteButton.click();
        BrowserUtilities.wait(2);


    }


}
