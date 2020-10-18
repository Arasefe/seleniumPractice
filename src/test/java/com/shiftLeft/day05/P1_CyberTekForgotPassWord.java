package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//TC #1: PracticeCybertek.com_ForgotPassword WebElement verification


public class P1_CyberTekForgotPassWord {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtilities.wait(2);
    }
    @Test
    public void p1_cyberTekForgotPassword(){
        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement home=driver.findElement(By.cssSelector("a.nav-link"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(home.isDisplayed(),"Home is not displayed!!!");
        //b. “Forgot password” header
        WebElement forgotPassword=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(forgotPassword.isDisplayed(),"forgot password is not displayed!!!");
        //c. “E-mail” text
        WebElement emailText=driver.findElement(By.xpath("//label[.='E-mail']"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(emailText.isDisplayed(),"email text is not displayed!!");
        //d.  E-mail input box
        WebElement emailBox=driver.findElement(By.xpath("//input[@type='text']"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(emailBox.isDisplayed(),"Email box is not displayed!!!");
        //e. “Retrieve password” button
        WebElement retrievePassword=driver.findElement(By.cssSelector("button#form_submit>i"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(retrievePassword.isDisplayed(),"retrieve button is not displayed!!!");
        //f. “Powered by Cybertek School” text
        WebElement poweredByCybertek=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        BrowserUtilities.wait(2);
        Assert.assertTrue(poweredByCybertek.isDisplayed(),"powered by cybertek is not displayed!!!");
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
