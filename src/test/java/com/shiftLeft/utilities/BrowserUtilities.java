package com.shiftLeft.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BrowserUtilities {
    /**
     Accepts a list of Web Element
     @param list
     @return List<String>
     Method should be returning a list of Strings
     */
    public static List<String> getElementsText(List<WebElement> list){

        List<String> webElementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webElementsAsString.add(each.getText());
        }
        return webElementsAsString;

    }

    /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch
     */
    public static void wait(int sec){


        try {
            Thread.sleep(1000 * sec);
        } catch (InterruptedException e) {
            //System.out.println("Interrupted exception caught");
            e.printStackTrace();
        }

    }
    // PRACTICE #4: Method: verifyOrder
    // Create a method named verifyOrder in SmartBearUtils class.
    // Method takes WebDriver object and String(name).
    // Method should verify if given name exists in orders.
    // This method should simply accepts a name(String), and assert whether
    // given name is in the list or not.
    // Create a new TestNG test to test if the method is working as expected.

    public static boolean verifyOrder(WebDriver driver,String name){
        WebDriverFactory.getDriver(name);
        List<String>list=new ArrayList<>(Arrays.asList("Aras","Tulpar","Banu","Efe","Ege","Ismail","Ali"));
        if(list.contains(name)){
            return true;
        }
        return false;
    }

}
