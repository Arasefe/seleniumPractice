package com.shiftLeft.day07;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

//PRACTICE #4: Method: verifyOrder
// Create a method named verifyOrder in SmartBearUtils class.
// Method takes WebDriver object and String(name).
// Method should verify if given name exists in orders.(Bob Feather)
// This method should simply accepts a name(String), and assert whether given name is in the list or not.
// Create a new TestNG test to test if the method is working as expected.
public class TC1_VerifyOrder {

    @Test
    public void tc1_verifyOrder() {
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
        List<WebElement> namesList = Driver.getDriver().findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));
        String expectedResult = "Bob Feather";

        for (WebElement each : namesList) {

            if (each.getText().equals(expectedResult)) {
                Assert.assertTrue(each.getText().equals(expectedResult));
                return;
            }
        }
        // Assert fail method will fail the test when it is called, no matter what.
        Assert.fail("Name: " + expectedResult + " does not exist in the list! Verification FAILED!!!");
    }
    @Test
    public void verifyCardNumber(){

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
        List<WebElement> namesList = Driver.getDriver().findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        String expectedResult = "444555444555";
        List<WebElement>cardNumbers=Driver.getDriver().findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[11]"));

        for (WebElement each : cardNumbers) {

            if(each.getText().equals(expectedResult)){
                Assert.assertTrue(true);
                return;
            }
        }
        Assert.fail("Credit Card Number "+expectedResult+ " does not exist in the list. Verification Failed!!!");
    }
}
