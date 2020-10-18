package com.shiftLeft.day10_hoverOver;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC #15: Hover Test
//1. Go to http://practice.cybertekschool.com/hovers
//2. Hover over to first image
//3. Assert:
//a. “name: user1” is displayed
//4. Hover over to second image
//5. Assert:
//a. “name: user2” is displayed
//6. Hover over to third image
//7. Confirm:
//a. “name: user3” is displayed
public class HoverOver {

    @Test
    public void tc15_hoverOver(){
        Driver.getDriver().get("http://practice.cybertekschool.com/hovers");
        //(//img[@src='/img/avatar-blank.jpg'])[1]
        WebElement img1 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement img2 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement img3 = Driver.getDriver().findElement(By.xpath("(//div[@class='figure'])[3]"));

        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        Actions action1=new Actions(Driver.getDriver());
        BrowserUtilities.wait(2);
        action1.moveToElement(img1).perform();
        //h5[.='name: user1']
        WebElement message1=Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        Assert.assertTrue(message1.isDisplayed());

        Actions action2=new Actions(Driver.getDriver());
        BrowserUtilities.wait(2);
        action2.moveToElement(img2).perform();
        //h5[.='name: user1']
        WebElement message2=Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        Assert.assertTrue(message2.isDisplayed());

        Actions action3=new Actions(Driver.getDriver());
        BrowserUtilities.wait(2);
        action3.moveToElement(img3).perform();
        //h5[.='name: user1']
        WebElement message3=Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));
        Assert.assertTrue(message3.isDisplayed());



    }
}
