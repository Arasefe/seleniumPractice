package com.shiftLeft.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class T5_EtsyTitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        // TC #5: Etsy Title Verification
        // 1. Open Chrome browser
        // 2. Go to https://www.etsy.com
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.etsy.com");
        Thread.sleep(2000);
    }


    @Test
    public void t5_etsyTitleVerification() throws InterruptedException{
        // 3. Search for “wooden spoon”
        // 4. Verify title:
        // Expected: “Wooden spoon | Etsy”
        WebElement searchBox=driver.findElement(By.name("search_query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        String expectedTitle="Wooden spoon | Etsy";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle,"Expected Title does not match with the Actual Title");
        Thread.sleep(2000);

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
