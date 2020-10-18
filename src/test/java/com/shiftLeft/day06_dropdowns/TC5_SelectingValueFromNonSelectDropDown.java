package com.shiftLeft.day06_dropdowns;
//TC #5: Selecting value from non-select dropdown

//3. Click to non-select dropdown
//4. Select Facebook from dropdown
//5. Verify title is “Facebook - Log In or Sign Up”

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC5_SelectingValueFromNonSelectDropDown {
    @Test
    public void tc5_selectingValueFromSelectDropDown(){
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
        //a[@id='dropdownMenuLink']
        WebElement dropDownLink=Driver.getDriver().findElement(By.xpath("//a[@id='dropdownMenuLink']"));
        dropDownLink.click();
        WebElement faceBookLink=Driver.getDriver().findElement(By.xpath("//a[.='Facebook']"));
        dropDownLink.click();
        BrowserUtilities.wait(4);
        String mainHandle=Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(mainHandle);
        String actualTitle=Driver.getDriver().getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";
        Assert.assertTrue(expectedTitle.equals(actualTitle));

    }
}
