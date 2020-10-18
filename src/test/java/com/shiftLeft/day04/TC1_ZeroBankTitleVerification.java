package com.shiftLeft.day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #1: Zero Bank title verification
// 1. Open Chrome browser
// 2. Go to http://zero.webappsecurity.com/login.html
// 3. Verify title
// Expected: “Zero - Log in”
public class TC1_ZeroBankTitleVerification {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
    }
    @Test
    public void tc1_zeroBankTitleVerification(){
        String expectedTitle="Zero - Log in";
        String actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.equals(expectedTitle));
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
