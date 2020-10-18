package com.shiftLeft.day05;

import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

// TC #03: FINDELEMENTS_APPLE
public class TC3_FindElementsApple {
    @Test
    public void tc3_findElementsApple(){
        // 1. Open Chrome browser
        // 2. Go to https://www.apple.com
        Driver.getDriver().get("https://www.apple.com");

        // 3. Click to all of the headers one by one


        // a. Mac, iPad, iPhone, Watch, TV, Music, Support
        WebElement mac=Driver.getDriver().findElement(By.xpath("(//a[@href='/mac/'])[1]"));
        mac.click();
        List<WebElement> linksMac=Driver.getDriver().findElements(By.tagName("a"));
        // 4. Print out how many links on each page with the titles of the pages
        System.out.println("Total links' size per page = " + linksMac.size());
        for (int i = 0; i < linksMac.size(); i++) {
            System.out.println("Title Of The page  = " + Driver.getDriver().getTitle());
            System.out.println(linksMac.get(i).getText());
        }

        //a[@class='ac-gn-link ac-gn-link-ipad']
        //-->css a[class='ac-gn-link ac-gn-link-ipad']
        WebElement ipad=Driver.getDriver().findElement(By.xpath("a[class='ac-gn-link ac-gn-link-ipad']"));
        ipad.click();
        List<WebElement>linksIpad=Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("Total links' size per page = " + linksIpad.size());
        for (int i = 0; i < linksIpad.size(); i++) {
            System.out.println("Title Of The page  = " + Driver.getDriver().getTitle());
            System.out.println(linksIpad.get(i).getText());
        }
        // 5. Loop through all
        // 6. Print out how many link is missing text TOTAL
        // 7. Print out how many link has text TOTAL
        // 8. Print out how many total link TOTAL

    }
}
