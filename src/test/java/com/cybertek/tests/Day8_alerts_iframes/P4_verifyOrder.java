package com.cybertek.tests.Day8_alerts_iframes;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class P4_verifyOrder {
    //PRACTICE #4: Method: verifyOrder
    // •Create a method named verify Order in SmartBearUtils class.
    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver); // from utilities class, pogledati
    }

    // using the verify order method from SmartBearUtility class

    @Test
    public void task4_verify_order(){

        SmartBearUtilities.verifyOrder(driver,"Mark Smith");
        //we did everything here,because we implement method from utility class, pogledati


    }

    // test bellow
    @Test

    //Create a method named printNamesAndCitiesin SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , City1: city
    // •Name2: name , City2: city


    public void test5_print_names_and_cities(){

        SmartBearUtilities.printNamesAndCities(driver);

    }

    //new test below



}
