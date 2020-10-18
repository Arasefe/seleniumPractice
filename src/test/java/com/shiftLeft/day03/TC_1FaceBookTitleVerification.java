package com.shiftLeft.day03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #1: Facebook title verification
// 1. Open Chrome browser
// 2. Go to https://www.facebook.com
// 3. Verify title:
// Expected: “Facebook - Log In or Sign Up”
public class TC_1FaceBookTitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(2000);
    }
    @Test
    public void tc1_facebook_TitleVerification(){
        // 3. Verify title:
        // Expected: “Facebook - Log In or Sign Up”
        String expectedTitle="Facebook - Log In or Sign Up";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"The expected Title does not match with the actual title.FAILED!!");
    }

    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();
    }
}
