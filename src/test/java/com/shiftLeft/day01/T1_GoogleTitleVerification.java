package com.shiftLeft.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #1: Google Title Verification
// 1. Open Chrome browser
// 2. Go to https://www.google.com
// 3. Verify title:
// Expected: Google
public class T1_GoogleTitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.google.com");
    }
    @Test
    public void t1_googleTitle_Verification(){
        String expectedResult="Google";
        String actualResult=driver.getTitle();
        Assert.assertTrue(expectedResult.equals(actualResult),"The expected title does not match with the actual title.FAILED!!");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        driver.close();
    }

}
