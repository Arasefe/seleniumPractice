package com.shiftLeft.day06_dropdowns;

import com.github.javafaker.Faker;
import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
// SmartBear software order placing





//• Generate: name, street, city, state, zip code
//10. Click on “visa” radio button
//11. Generate card number using JavaFaker
//12. Click on “Process”
//13.Verify success message “New order has been successfully added.”
public class TC7_SmartBearOrderVerification {
    @Test
    public void tc7_smartBearOrderVerification() throws InterruptedException {
        //1. Open browser
        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //3. Enter username: “Tester”
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        userName.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        //5. Click on Login button
        WebElement login = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        login.click();
        //6. Click on Order
        WebElement order = Driver.getDriver().findElement(By.xpath("//a[.='Order']"));
        order.click();
        //7. Select familyAlbum from product, set quantity to 2
        Select product = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']")));
        product.selectByVisibleText("FamilyAlbum");
        //input[@id='ctl00_MainContent_fmwOrder_txtQuantity']
        WebElement quantity = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantity.clear();
        quantity.sendKeys("2");
        //8. Click to “Calculate” button
        //input[@value='Calculate']
        WebElement calculate = Driver.getDriver().findElement(By.xpath("//input[@value='Calculate']"));
        calculate.click();
        //id=ctl00_MainContent_fmwOrder_txtName
        Faker faker = new Faker();
        WebElement customerName = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        customerName.sendKeys(faker.name().fullName());
        //ctl00_MainContent_fmwOrder_TextBox2
        WebElement street = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        street.sendKeys(faker.address().streetAddress());
        //ctl00_MainContent_fmwOrder_TextBox3
        WebElement city = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        city.sendKeys(faker.address().cityName());
        //ctl00_MainContent_fmwOrder_TextBox4
        WebElement state = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        state.sendKeys(faker.address().stateAbbr());
        //ctl00_MainContent_fmwOrder_TextBox5
        WebElement zipCode = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.sendKeys(faker.address().zipCode().replaceAll("-",""));
        //ctl00$MainContent$fmwOrder$cardList
        WebElement visaButton = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();
        WebElement creditCard = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        creditCard.sendKeys(faker.finance().creditCard().replaceAll("-",""));
        //ctl00_MainContent_fmwOrder_TextBox1
        WebElement expiryDate = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expiryDate.sendKeys(faker.business().creditCardExpiry().substring(2).replaceAll("-","/"));
        //ctl00_MainContent_fmwOrder_InsertButton
        WebElement process = Driver.getDriver().findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        process.click();
        //*[@id="ctl00_MainContent_fmwOrder"]//strong
        WebElement message = Driver.getDriver().findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]//strong"));
        String expectedMessage = "New order has been successfully added.";
        String actualMessage = message.getText();
        Assert.assertTrue(actualMessage.equals(expectedMessage), "The message does not Match");
        BrowserUtilities.wait(3);
        Driver.closeDriver();

    }
}