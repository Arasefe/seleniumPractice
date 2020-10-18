package com.shiftLeft.day09_Alerts;
//TC #1: Information alert practice

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//3. Click to “Click for JS Alert” button
//4. Click to OK button from the alert
//5. Verify “Y ou successfully clicked an alert” text is displayed.
public class TC1_InformationAlert {
    @Test
    public void tc1_informationAlert(){
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/javascript_alerts
        Driver.getDriver().get("http://practice.cybertekschool.com/javascript_alerts");
        Driver.getDriver().manage().window().maximize();

        //button[.='Click for JS Alert']
        WebElement jsAlert= Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Alert']"));
        jsAlert.click();

        Alert js=Driver.getDriver().switchTo().alert();
        js.accept();
        WebElement messageInformation=Driver.getDriver().findElement(By.xpath("//p[.='You successfuly clicked an alert']"));
        String expectedMessage1="You successfuly clicked an alert";
        String actualMessage1=messageInformation.getText();
        Assert.assertEquals(expectedMessage1,actualMessage1);
        BrowserUtilities.wait(3);

        //button[.='Click for JS Confirm']
        WebElement jsConfirm=Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Confirm']"));
        jsConfirm.click();
        Alert confirm=Driver.getDriver().switchTo().alert();
        confirm.accept();
        //p[.='You clicked: Ok']
        WebElement messageConfirmation=Driver.getDriver().findElement(By.xpath("//p[@id='result']"));
        String expectedMessage2="You clicked: Ok";
        String actualMessage2=messageConfirmation.getText();
        Assert.assertEquals(expectedMessage2,actualMessage2);
        BrowserUtilities.wait(3);

        //button[.='Click for JS Prompt']

        WebElement jsPrompt=Driver.getDriver().findElement(By.xpath("//button[.='Click for JS Prompt']"));
        jsPrompt.click();
        Alert prompt=Driver.getDriver().switchTo().alert();
        prompt.sendKeys("efehan");
        prompt.accept();
        //button[@onclick='jsPrompt()']
        //p[.='You entered: efehan']
        WebElement messagePrompt=Driver.getDriver().findElement(By.xpath("//p[.='You entered: efehan']"));
        String expectedMessage3="efehan";
        String actualMessage3=messagePrompt.getText();
        Assert.assertTrue(actualMessage3.contains(expectedMessage3));
        BrowserUtilities.wait(3);

        Driver.closeDriver();

    }
}
