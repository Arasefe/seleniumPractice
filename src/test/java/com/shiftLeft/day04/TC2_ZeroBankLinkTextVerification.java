package com.shiftLeft.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC2_ZeroBankLinkTextVerification {
    // TC #2: Zero Bank link text verification


    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        // 1. Open Chrome browser
        // 2. Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @Test
    public void tc1_zeroBankTitleVerification(){
        // 3. Verify link text from top left:
        // Expected: “Zero Bank”
        WebElement linkText=driver.findElement(By.xpath("//a[@href='/index.html']"));
        String expectedLinkText="Zero Bank";
        String actualLinkText=linkText.getText();
        // 4. Verify link href attribute value contains:
        // Expected: “index.html”
        String expectedLinkAttribute="index.html";
        //WebElement linkText=driver.findElement(By.xpath("//a[@href='/index.html']"));
        String actualLinkAttribute=linkText.getAttribute("href");

        Assert.assertTrue(actualLinkText.equals(expectedLinkText));
        Assert.assertTrue(actualLinkAttribute.contains(expectedLinkAttribute));
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
