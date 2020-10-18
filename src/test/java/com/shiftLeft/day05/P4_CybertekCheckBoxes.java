package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// Practice: Cybertek Checkboxes


public class P4_CybertekCheckBoxes {

    @Test
    public void p4_cybertekCheckBoxes(){
        // 1. Go to http://practice.cybertekschool.com/checkboxes
        Driver.getDriver().get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtilities.wait(3);
        // 2. Confirm checkbox #1 is NOT selected by default
        // (//input[@type='checkbox'])[1]
        WebElement checkBox1=Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        Assert.assertTrue(!(checkBox1.isSelected()),"Checkbox1 is selected");
        // 3. Confirm checkbox #2 is SELECTED by default.
        WebElement checkBox2=Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Assert.assertTrue(checkBox2.isSelected(),"Checkbox2 is NOT selected");
        // 4. Click checkbox #1 to select it.
        checkBox1.click();
        Assert.assertTrue(checkBox1.isSelected(),"Checkbox1 is selected");
        // 5. Click checkbox #2 to deselect it.
        checkBox2.click();
        Assert.assertTrue(!(checkBox2.isSelected()),"Checkbox2 is NOT selected");
        // 6. Confirm checkbox #1 is SELECTED.
        // 7. Confirm checkbox #2 is NOT selected
    }


}
