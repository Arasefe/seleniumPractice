package com.shiftLeft.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_3FaceBookHeaderVerification {
    // TC #3: Facebook header verification
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        // 1. Open Chrome browser
        // 2. Go to https://www.facebook.com
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

    }

    @Test
    public void tc3_faceBookHeaderVerification() throws InterruptedException{
        // 3. Verify header text is as expected:

        WebElement header=driver.findElement(By.xpath("//h2[.='Connect with friends and the world around you on Facebook.']"));
        Thread.sleep(1000);
        // Expected: “Connect with friends and the world around you on Facebook.”
        String expectedTitle="Connect with friends and the world around you on Facebook.";
        String actualTitle=header.getText();

        Assert.assertEquals(actualTitle,expectedTitle,"FAILED!!!");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
