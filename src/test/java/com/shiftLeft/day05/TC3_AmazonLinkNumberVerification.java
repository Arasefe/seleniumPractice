package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//TC #3: Amazon link number verification

//3. Enter search term (use cssSelector to locate search box)
//4. Verify title contains search term
public class TC3_AmazonLinkNumberVerification {
    //1. Open Chrome browser
    //2. Go to https://www.amazon.com
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");
        BrowserUtilities.wait(2);
    }
    @Test
    public void tc3_amazonLinkVerification(){
        WebElement searchBox=driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("water melon"+ Keys.ENTER);

        BrowserUtilities.wait(3);
        String expectedTitle="water melon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle),"The title does not contain searched term.FAILED!!!");
        BrowserUtilities.wait(3);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
