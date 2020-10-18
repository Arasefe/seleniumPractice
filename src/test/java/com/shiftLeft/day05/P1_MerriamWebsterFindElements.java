package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

// TC #0: FINDELEMENTS

// 4. Print out how many link is missing text
// 5. Print out how many link has text
// 6. Print out how many total link
public class P1_MerriamWebsterFindElements {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        // 1. Open Chrome browser
        // 2. Go to https://www.merriam-webster.com/
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com/");
        BrowserUtilities.wait(5);
    }
    @Test
    public void p1_merriamWebster_FindElements(){
        // 3. Print out the texts of all links

//        List<WebElement> list=driver.findElements(By.tagName("link"));
//        for (WebElement each : list) {
//            System.out.println(each.getText());
//        }

        // 4. Print out how many link is missing text
        // 5. Print out how many link has text
        // 6. Print out how many total link
        driver.findElements(By.tagName("link"));

    }



}
