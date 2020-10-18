package com.shiftLeft.day01;

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

// TC #4: Google search
// 1- Open a chrome browser
// 2- Go to: https://google.com
// 3- Write “apple” in search box
// 4- Click google search button
// 5- Verify title:
// Expected: Title should start with “apple” word
public class T4_GoogleSearch_Verification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(2000);
    }
    @Test
    public void t4_GoogleSearch_Verification() throws InterruptedException{
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);
        Thread.sleep(3000);
        String expectedTitle="apple";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.startsWith(expectedTitle),"FAILED!!!");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
}
