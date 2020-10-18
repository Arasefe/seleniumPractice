package com.shiftLeft.day04;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import com.sun.javaws.security.SigningInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #3: Zero Bank login title verification
// 1. Open Chrome browser
// 2. Go to http://zero.webappsecurity.com/login.html

public class TC3_ZeroBankLoginTitleVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://zero.webappsecurity.com/login.html");
        BrowserUtilities.wait(2);
    }
    @Test
    public void tc3_zeroBankTitleVerification(){
        // 3. Enter username: username
        // 4. Enter password: password
        // 5. Verify title changed to:
        // Expected: “Zero – Account Summary”

        WebElement login=driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");
        WebElement passWord=driver.findElement(By.xpath("//input[@id='user_password']"));
        passWord.sendKeys("password");
        //input[@type='submit']
        WebElement signIn=driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();
        BrowserUtilities.wait(2);
        String expectedTitle="Zero - Account Summary";
        String actualTitle=driver.getTitle();
        BrowserUtilities.wait(1);
        System.out.println(actualTitle);
        Assert.assertTrue(expectedTitle.equals(actualTitle),"FAILED!!!");
    }

    public void tearDown(){
        driver.close();
    }
}
