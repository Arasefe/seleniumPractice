package com.shiftLeft.day05;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

// SeleniumEasy Checkbox Verification – Section 2



public class TC5_SeleniumCheckBoxVerificationII {

    @Test
    public void tc5_seleniumCheckBoxVerificationII() throws InterruptedException {
        // 1. Open Chrome browser
        // 2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        Driver.getDriver().get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Driver.getDriver().manage().window().maximize();
        BrowserUtilities.wait(3);
        // 3. Verify “Check All” button text is “Check All”
        WebElement checkAll=Driver.getDriver().findElement(By.id("check1"));
        String expectedText1="Check All";
        String actualText1=checkAll.getAttribute("value");
        Assert.assertEquals(actualText1, expectedText1,"Check All FAILED");
        BrowserUtilities.wait(3);
        // 4. Click to “Check All” button
        // 5. Verify all check boxes are checked
        //(//input[@type='checkbox'])[2]
        // 6. Verify button text changed to “Uncheck All”
        checkAll.click();
        WebElement uncheckAll=Driver.getDriver().findElement(By.xpath("//input[@value='Uncheck All']"));
        String expectedText="Uncheck All";
        String actualText=uncheckAll.getAttribute("value");
        BrowserUtilities.wait(3);
        Assert.assertEquals(actualText, expectedText, "Uncheck All FAILED!!!");

        Driver.closeDriver();

    }
}
