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


public class TC_2FaceBookIncorrectLoginTitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException {
        // TC #2: Facebook incorrect login title verification
        // 1. Open Chrome browser
        // 2. Go to https://www.facebook.com
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);

    }
    @Test
    public void tc2_faceBookIncorrectLoginTitleVerification() throws InterruptedException{
        // 3. Enter incorrect username
        WebElement email=driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("efehan_pusat@yahoo.com");
        Thread.sleep(1000);
        // 4. Enter incorrect password
        WebElement passWord=driver.findElement(By.xpath("//input[@id='pass']"));
        passWord.sendKeys("Banu_Torun82");
        Thread.sleep(1000);
        // 5. Verify title changed to:
        // Expected: “Log into Facebook | Facebook”
        WebElement login=driver.findElement(By.xpath("//button[@id='u_0_b']"));
        login.click();
        Thread.sleep(1000);

        String expectedTitle="Log into Facebook | Facebook";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"FAILED!!!!");
    }
    @AfterMethod
    public void tearDown(){
       driver.close();
    }
}
