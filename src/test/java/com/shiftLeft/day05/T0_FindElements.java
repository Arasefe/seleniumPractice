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
// TC #0: FINDELEMENTS


public class T0_FindElements {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        BrowserUtilities.wait(2);
    }
    @Test
    public void t0_findElements(){
        // 3. Print out the texts of all links
        // 4. Print out how many total link
        // 3. Enter any email into input box
        WebElement home=driver.findElement(By.xpath("//a[.='Home']"));
        System.out.println(home.getText());
        WebElement forgotPassword=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        System.out.println(forgotPassword.getText());
        WebElement email=driver.findElement(By.xpath("//label[.='E-mail']"));
        System.out.println(email.getText());
        WebElement retrievePassword=driver.findElement(By.xpath("//i[.='Retrieve password']"));
        System.out.println(retrievePassword.getText());
        WebElement poweredByCybertek=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        System.out.println(poweredByCybertek.getText());

    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
