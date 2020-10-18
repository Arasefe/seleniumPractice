package com.shiftLeft.day09_Alerts;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC #4 : Iframe practice
//1. Create a new class called: IframePractice
//2. Create new test and make set ups
//3. Go to: http://practice.cybertekschool.com/iframe
//4. Assert: “Your content goes here.” Text is displayed.
//5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor
public class TC4_IFramePractice {

    @Test
    public void tc4_iFramePractice(){
        //2. Create new test and make set ups
        //3. Go to: http://practice.cybertekschool.com/iframe
        Driver.getDriver().get("http://practice.cybertekschool.com/iframe");
        //iframe[@id='mce_0_ifr']
        WebElement iframe=Driver.getDriver().findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        Driver.getDriver().switchTo().frame(iframe);
        //p[.='Your content goes here.']
        WebElement message=Driver.getDriver().findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(message.isDisplayed(),"Your content goes here message is not Displayed!!!");
        Driver.getDriver().switchTo().defaultContent();
        Driver.closeDriver();

    }
}
