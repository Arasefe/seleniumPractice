package com.shiftLeft.day06_dropdowns;
//TC #2: Selecting state from State dropdown and verifying result

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;




//Use all Select options. (visible text, value, index)
public class TC2_SelectingStateAndVerification {
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    @Test
    public void tc2_selectingState(){
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        Driver.getDriver().manage().window().fullscreen();
        //3. Select Illinois

        Select select=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));
        select.selectByVisibleText("Illinois");
        BrowserUtilities.wait(3);
        //4. Select Virginia then Alabama
        select.selectByValue("VA");
        BrowserUtilities.wait(1);
        select.selectByIndex(1);        // AL
        BrowserUtilities.wait(3);
        //5. Select California
        //6. Verify final selected option is California.
        select.selectByVisibleText("California");
        Assert.assertEquals(select.getFirstSelectedOption().getText(), "California");

    }
}
