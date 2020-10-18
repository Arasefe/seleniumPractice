package com.shiftLeft.day08;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

//TC#8: Cybertek “month” dropdown list of default values verification

// Expected: Options should contain all 12 months of the year.
public class TC8_CyberTekDropDown {

    @Test
    public void tc8_cyberTekDropDown(){
        //1. Do both verifications in the same test
        //2. Verify list of months are correct as expected.
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        Driver.getDriver().manage().window().maximize();
        Select select= new Select(Driver.getDriver().findElement(By.xpath("//select[@id='month']")));
        List<WebElement> months= select.getOptions();

        for (int i = 0; i < months.size(); i++) {
            System.out.println(months.get(i).getText());
        }
        //System.out.println(months);
    }
}
