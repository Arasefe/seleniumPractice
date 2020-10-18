package com.shiftLeft.day08;

import com.github.javafaker.Faker;
import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC#6: Cybertek registration form confirmation Note: Use JavaFaker when possible.
//1. Open browser
//2. Go to website: http://practice.cybertekschool.com/registration_form
//3. Enter first name
//4. Enter last name
//5. Enter username
//6. Enter email address
//7. Enter password
//8. Enter phone number
//9. Select a gender from radio buttons
//10. Enter date of birth
//11. Select Department/Office
//12. Select Job Title
//13. Select programming language from checkboxes
//14. Click to sign up button
//15.Verify success message “You’ve successfully completed registration.” is
//displayed.
public class TC1_CyberTekRegistration {
    @Test
    public void tc1_cyberTekRegistration(){
        Driver.getDriver().get("http://practice.cybertekschool.com/registration_form");
        Driver.getDriver().manage().window().maximize();

        //input[@name='firstname']
        WebElement name=Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        Faker faker=new Faker();
        name.sendKeys(faker.name().firstName());

        WebElement lastName=Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        WebElement userName=Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("ArasEfe");

        WebElement email=Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("efehan_pusat@yahoo.com");

        WebElement password=Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.internet().password());

        WebElement phoneNumber=Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phoneNumber.sendKeys("773-510-3092");

        WebElement genderMale=Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderMale.click();

        WebElement birthday=Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys("01/01/1977");

        Select department=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByVisibleText("Department of Engineering");

        Select jobType=new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobType.selectByVisibleText("SDET");

        WebElement pLanguage=Driver.getDriver().findElement(By.xpath("//input[@id='inlineCheckbox2']"));
        pLanguage.click();

        BrowserUtilities.wait(2);
        WebElement submit=Driver.getDriver().findElement(By.xpath("//button[.='Sign up']"));
        submit.click();

        //h4[.='Well done!']
        WebElement message=Driver.getDriver().findElement(By.xpath("//h4[.='Well done!']"));

        String expectedMessage="Well done!";
        String actualMessage=message.getText();
        Assert.assertTrue(expectedMessage.equals(actualMessage));

    }

}
