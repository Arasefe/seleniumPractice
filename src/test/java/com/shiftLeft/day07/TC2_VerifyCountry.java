package com.shiftLeft.day07;


import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC2_VerifyCountry {
    @Test
    public void tc2_verifyCountry(){

        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        //5. Click on Login button
        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        //6. Click on Order
        List<WebElement> namesList = Driver.getDriver().findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[8]"));
        String expectedResult = "Great Britain";

        for (WebElement each : namesList) {

            if (each.getText().equals(expectedResult)) {
                Assert.assertTrue(each.getText().equals(expectedResult));
                return;
            }
        }
        // Assert fail method will fail the test when it is called, no matter what.
        Assert.fail("Country: " + expectedResult + " does not exist in the list! Verification FAILED!!!");
    }
}
