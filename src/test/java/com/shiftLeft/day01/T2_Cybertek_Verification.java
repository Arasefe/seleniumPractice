package com.shiftLeft.day01;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #2: Cybertek verifications
// 1. Open Chrome browser
// 2. Go to https://practice.cybertekschool.com
// 3. Verify URL contains
// Expected: cybertekschool
// 4. Verify title:
// Expected: Practice
public class T2_Cybertek_Verification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://practice.cybertekschool.com/");
        Thread.sleep(2000);
    }
    @Test
    public void t2_cyberTek_Verification(){
        String expectedUrl="cybertekschool";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl), "The actual url does NOT contain expected url. FAILED");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }


}
