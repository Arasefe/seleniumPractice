package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TC3_CyberTekForgotPasswordUrlVerification {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/forgot_password
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/forgot_password");
    }
    @Test
    public void tc3_cyberTekForgotPasswordUrlVerification(){
        // 3. Enter any email into input box
        WebElement email=driver.findElement(By.cssSelector("input[type='text']"));
        email.sendKeys("efehan_pusat@yahoo.com");
        // 4. Click on Retrieve password
        WebElement retrieve=driver.findElement(By.cssSelector("button#form_submit>i"));
        retrieve.click();
        BrowserUtilities.wait(2);
        // 5. Verify URL contains:
        // Expected: “email_sent”
        String expectedUrl="email_sent";
        String actualUrl=driver.getCurrentUrl();
        System.out.println(actualUrl);
        Assert.assertTrue(actualUrl.contains(expectedUrl),"The expected Url does not contain actual Url");
        BrowserUtilities.wait(2);
        // 6. Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”
        WebElement textBox=driver.findElement(By.xpath("//h4[@name='confirmation_message']"));
        String expectedText="Your e-mail’s been sent!";
        Assert.assertTrue(textBox.isDisplayed());

    }

    public void tearDown(){
        driver.close();
    }


}
