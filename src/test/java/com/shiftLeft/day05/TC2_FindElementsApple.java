package com.shiftLeft.day05;
// TC #02: FINDELEMENTS_APPLE

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 5. Print out how many link is missing text
// 6. Print out how many link has text
// 7. Print out how many total link
public class TC2_FindElementsApple {
    // 1. Open Chrome browser
    // 2. Go to https://www.apple.com
    @Test
    public void tc2_findElementApple(){
        Driver.getDriver().get("https://www.apple.com");
        BrowserUtilities.wait(3);
        // 3. Click to iPhone
        //(//a[@href='/iphone/'])[1]
        WebElement iphone=Driver.getDriver().findElement(By.xpath("(//a[@href='/iphone/'])[1]"));
        iphone.click();
        // 4. Print out the texts of all links
        List<WebElement> links=new ArrayList<>(Driver.getDriver().findElements(By.tagName("a")));

        System.out.println("Total links.size() = " + links.size());
        int linkWithText=0;
        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
            if(links.get(i).getText()!=null){
                linkWithText++;
            }
        }
        System.out.println("linksWithText = " + linkWithText);


    }
}
