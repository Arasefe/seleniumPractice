package com.shiftLeft.day08;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TC#7: Cybertek “month” dropdown default value


public class TC7_CyberTekMonthDropDown {

    @Test
    public static void tc7_cyberTekDropdown(){
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/dropdowns
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        Driver.getDriver().manage().window().maximize();

        //3. Verify default value is always showing the current month
        // Expected: If currently in June, should show June selected.

        Select month=new Select(Driver.getDriver().findElement(By.xpath("//select[@id='month']")));
        String expectedMonth= LocalDateTime.now().getMonth().name();
        String actualMonth=month.getFirstSelectedOption().getText();

        Assert.assertEquals(actualMonth.toLowerCase(), expectedMonth.toLowerCase());

        Driver.closeDriver();

    }
}
