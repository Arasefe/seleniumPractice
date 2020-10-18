package com.shiftLeft.day06_dropdowns;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

// Selecting date on dropdown and verifying


// Select year using Select month using Select day using visible text, value attribute, index number
public class TC3_SelectingDateAndVerification {
    @Test
    public void tc3_selectingDateAndVerification() throws InterruptedException {
        // 1. Open Chrome browser
        // 2. Go to http://practice.cybertekschool.com/dropdown
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        Driver.getDriver().manage().window().fullscreen();
        // 3. Select “December 1 , 1921” and verify it is selected.
        Select year=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1921");
        Select month=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='month']")));
        month.selectByValue("11");
        Select day=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='day']")));
        day.selectByIndex(0);
        Assert.assertTrue(year.getFirstSelectedOption().isSelected(),"Year is not selected.Failed!!!");
        Assert.assertTrue(month.getFirstSelectedOption().isSelected(),"Month is not selected.Failed!!!");
        Assert.assertTrue(day.getFirstSelectedOption().isSelected(),"Day is not selected.Failed!!!");


        Driver.closeDriver();


    }
}
