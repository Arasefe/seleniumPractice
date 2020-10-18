package com.shiftLeft.day06_dropdowns;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC1_VerifySimpleDropDowns {
    @Test
    public void tc1_verifySimpleDropDowns(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        Driver.getDriver().manage().window().maximize();
        //3. Verify “Simple dropdown” default selected value is correct
        // Expected: “Please select an option”
        Select select=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='dropdown']")));
        String actualSelectText=select.getFirstSelectedOption().getText();
        String expectedSelectText="Please select an option";
        Assert.assertTrue(expectedSelectText.equals(actualSelectText),"Failed!!!");
        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        select=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='state']")));
        String expectedStateSelection="Select a State";
        String actualStateSelection=select.getFirstSelectedOption().getText();
        Assert.assertTrue(expectedStateSelection.equals(actualStateSelection),"State selection Failed!!!");

        Driver.getDriver().close();
    }

}
