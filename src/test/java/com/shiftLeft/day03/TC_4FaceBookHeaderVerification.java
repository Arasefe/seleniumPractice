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

//TC #4: Facebook header verification
//1. Open Chrome browser
//2. Go to https://www.facebook.com

public class TC_4FaceBookHeaderVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
    }
    @Test
    public void tc_4faceBookHeaderVerification(){
        //3. Verify “Create a page” link href value contains text:
        //Expected: “registration_form”

        WebElement createAPage=driver.findElement(By.linkText("Create a Page"));
        String expectedValue="registration_form";
        String actualValue=createAPage.getAttribute("href");
        Assert.assertTrue(actualValue.contains(expectedValue),"FAILED!!!");

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
