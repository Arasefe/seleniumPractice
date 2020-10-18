package com.shiftLeft.day04;

import com.shiftLeft.utilities.BrowserUtilities;
import com.shiftLeft.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
// TC #4: Zero Bank login title verification


public class TC4_ZeroBankLoginTitleVerification {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // 1. Open Chrome browser
        // 2. Go to http://zero.webappsecurity.com/login.html
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://zero.webappsecurity.com/login.html");
        BrowserUtilities.wait(1);
        // 3. Enter username: username
        WebElement login = driver.findElement(By.xpath("//input[@id='user_login']"));
        login.sendKeys("username");
        // 4. Enter password: password
        WebElement passWord = driver.findElement(By.xpath("//input[@id='user_password']"));
        passWord.sendKeys("password");
        //input[@type='submit']
        WebElement signIn = driver.findElement(By.xpath("//input[@type='submit']"));
        signIn.click();
        BrowserUtilities.wait(3);
    }

    @Test
    public void tc4_accountActivity() {

        // 5. Click to “Account Activity” link
        // 6. Verify title changed to:
        // Expected: “Zero – Account Activity”
        //a[.='Account Activity']
        //WebElement accountActivity = driver.findElement(By.cssSelector("a[href='/bank/redirect.html?url=account-activity.html']"));
        WebElement accountActivity = driver.findElement(By.xpath("//a[.='Account Activity']"));
        accountActivity.click();
        BrowserUtilities.wait(3);

        String expectedTitleAccountActivity = "Zero – Account Activity";
        String actualTitleAccountActivity = driver.getTitle();
        Assert.assertEquals(expectedTitleAccountActivity, actualTitleAccountActivity, "FAILED to confirm expected title matching the actual title");

    }
    @Test
    public void tc4_transferFund() {
        // 7. Click to “Transfer Funds” link
        // 8. Verify title changed to:Expected: “Zero – Transfer Funds”
        // a[.='Transfer Funds']
        // CSS a[href='/bank/redirect.html?url=account-activity.html']
        //WebElement transferFund = driver.findElement(By.cssSelector("a[href='/bank/redirect.html?url=transfer-funds.html']"));
        WebElement transferFund = driver.findElement(By.xpath("//a[.='Transfer Funds']"));
        transferFund.click();
        BrowserUtilities.wait(3);
        String expectedTitleTransferFund = "Zero – Transfer Funds";
        String actualTitleTransferFund = driver.getTitle();
        Assert.assertEquals(actualTitleTransferFund, expectedTitleTransferFund, "FAILED to confirm expected title matching the actual title");
    }
    @Test
    public void tc4_payBill() {
        // 9. Click to “Pay Bills” link
        // 10. Verify title changed to:
        // Expected: “Zero - Pay Bills”
        // ===> CSS a[href='/bank/redirect.html?url=pay-bills.html']
        //WebElement payBill = driver.findElement(By.cssSelector("a[href='/bank/redirect.html?url=pay-bills.html']"));
        WebElement payBill = driver.findElement(By.xpath("//a[.='Pay Bills']"));
        payBill.click();
        BrowserUtilities.wait(3);
        String expectedTitlePayBill = "Zero - Pay Bills";
        String actualTitlePayBill = driver.getTitle();
        Assert.assertEquals(actualTitlePayBill, expectedTitlePayBill, "FAILED to confirm expected title matching the actual title");
    }
    @Test
    public void tc4_myMoneyMap() {
        // 11. Click to “My Money Map” link
        // 12. Verify title changed to:
        // Expected: “Zero – My Money Map”
        // ===> CSS a[href='/bank/redirect.html?url=money-map.html']
        //WebElement moneyMap = driver.findElement(By.cssSelector("a[href='/bank/redirect.html?url=money-map.html']"));
        WebElement moneyMap = driver.findElement(By.xpath("//a[.='My Money Map']"));
        moneyMap.click();
        BrowserUtilities.wait(3);
        String expectedTitleMoneyMap = "Zero – My Money Map";
        String actualTitleMoneyMap = driver.getTitle();
        Assert.assertEquals(actualTitleMoneyMap, expectedTitleMoneyMap, "FAILED to confirm expected title matching the actual title");
    }
    @Test
    public void tc4_onlineStatements() {
        // 13. Click to “Online Statements” link
        // 14. Verify title changed to:
        // Expected: “Zero – Online Statements”
        // CSS a[href='/bank/redirect.html?url=online-statements.html']
        //WebElement onlineStatements=driver.findElement(By.cssSelector("a[href='/bank/redirect.html?url=online-statements.html']"));
        WebElement onlineStatements = driver.findElement(By.xpath("//a[.='Online Statements']"));
        onlineStatements.click();
        BrowserUtilities.wait(3);
        String expectedTitleOnlineStatements = "Zero – Online Statements";
        String actualTitleOnlineStatements = driver.getTitle();
        Assert.assertEquals(actualTitleOnlineStatements, expectedTitleOnlineStatements, "FAILED to confirm expected title matching the actual title");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
