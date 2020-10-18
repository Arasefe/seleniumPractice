package com.shiftLeft.day06_dropdowns;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//TC #1: Smartbear software link verification
//1. Open browser
//2. Go to website:
//http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
//3. Enter username: “Tester”
//4. Enter password: “test”
//5. Click to Login button
//6. Print out count of all the links on landing page
//7. Print out each link text on this page
//Mini-Task:
//• Create a method called loginToSmartBear
//• This method simply logs in to SmartBear when you call it.
//• Accepts WebDriver type as parameter
public class TC6_SmartBearLinkVerification {
    @Test
    public void tc6_smartBearLinkVerification() {
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");

        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();

        List<WebElement>links=Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Total links' size per page = " + links.size());
        for (int i = 0; i < links.size(); i++) {
            System.out.println("Title Of The page  = " + Driver.getDriver().getTitle());
            System.out.println(links.get(i).getText());
        }

    }
}
