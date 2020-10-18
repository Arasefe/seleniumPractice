package com.shiftLeft.day01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

// TC #3: Back and forth navigation
// 1- Open a chrome browser
// 2- Go to: https://google.com
// 3- Click to Gmail from top right.
// 4- Verify title contains:
// Expected: Gmail
// 5- Go back to Google by using the .back();
// 6- Verify title equals:Expected: Google

public class T3_BackAndForthNavigation {
    WebDriver driver;

    @BeforeMethod
    public void setUp() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(2000);

    }
    @Test
    public void t3_backAndForthNavigation() throws InterruptedException{
        // 3- Click to Gmail from top right.
        //(//a[@class='gb_g'])[1]
        WebElement gmailButton=driver.findElement(By.xpath("(//a[@class='gb_g'])[1]"));
        gmailButton.click();
        Thread.sleep(2000);

        String expectedTitleGmail="Gmail";
        String actualTitleGmail=driver.getTitle();
        driver.navigate().back();
        String expectedResultGoogle="Google";
        String actualTitleGoogle=driver.getTitle();

        Assert.assertTrue(actualTitleGmail.contains(expectedTitleGmail),"The actual Gmail Title does not contain expected Gmail Title.FAILED!!");
        Assert.assertEquals(expectedResultGoogle, actualTitleGoogle, "The actual Google Title does not equal to expected Google Title. FAILED!!");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(2000);
        driver.close();

    }

}
