package com.shiftLeft.day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class T6_ZeroBankHeaderVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        // TC #6: Zero Bank header verification
        // 1. Open Chrome browser
        // 2. Go to http://zero.webappsecurity.com/login.html
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(2000);
    }
    @Test
    public void t6_zeroBank_HeaderVerification() throws InterruptedException{
        // 3. Verify header text
        // Expected: “Log in to ZeroBank”
        //h3[.='Log in to ZeroBank']
        String expectedHeader="Log in to ZeroBank";
        String actualHeader=driver.findElement(By.xpath("//h3[.='Log in to ZeroBank']")).getText();

        Assert.assertEquals(expectedHeader,actualHeader,"The actual header does not match with expected header. FAILED!!");
        Thread.sleep(2000);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
