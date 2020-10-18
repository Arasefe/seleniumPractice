package com.shiftLeft.day05;
// SeleniumEasy Checkbox Verification – Section 1

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;




public class TC4_SeleniumCheckBoxVerificationI {
    @Test
    public void tc4_seleniumCheckBoxVerification() throws InterruptedException {
        // 1. Open Chrome browser

        // 2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        Driver.getDriver().get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Driver.getDriver().manage().window().maximize();
        BrowserUtilities.wait(2);
        // 3. Verify “Success – Check box is checked” message is NOT displayed.
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Success – Check box is checked");
        BrowserUtilities.wait(2);
        // 4. Click to checkbox under “Single Checkbox Demo” section
        //input#isAgeSelected
        WebElement checkBox=Driver.getDriver().findElement(By.cssSelector("input#isAgeSelected"));
        checkBox.click();
        BrowserUtilities.wait(2);
        // 5. Verify “Success – Check box is checked” message is displayed.
        String expectedResult="Success - Check box is checked";
        String actualResult=Driver.getDriver().findElement(By.xpath("//div[.='Success - Check box is checked']")).getText();
        Assert.assertTrue(actualResult.equals(expectedResult));
        BrowserUtilities.wait(2);

        Driver.closeDriver();
    }
}
