package com.cybertek.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SmartBearUtilities {

    //  Mini-Task:
    //  #1 - Create a new class called: SmartBearUtilities
    //  #2 - Create a static method called loginToSmartBear
    //  #3 - This method simply logs in to SmartBear when you call it.
    //  #4 - Accepts WebDriver type as parameter


    public static void loginToSmartBear(WebDriver driver){
        // 3.Enter username: “Tester”
        WebElement userNameInput = driver.findElement (By.xpath("//input[@name='ctl00$MainContent$username']"));
        userNameInput.sendKeys("Tester");

        // 4.Enter password: “test”
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$password']"));
        passwordInput.sendKeys("test");

        // 5.Click to Login button
        WebElement loginButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginButton.click();


    }




    // new one below:

    // •Method takes WebDriver object and String(name).
    // •Method should verify if given name exists in orders.
    // •This method should simply accepts a name(String), and assert whether given name is in the list or not.
    // •Create a new TestNG test to test if the method is working as expected.


         public static void verifyOrder(WebDriver driver, String name){


        //Created a locator that only return the names of the customer from all of the rows
        //Created a list and stored the cells that has customer name information into it.
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //if there is only one table on the page,you don't have to locate the table -->//tr/td[2]
        // List<WebElement> namesList = driver.findElements(By.xpath("//tr/td[2]"));

        for (WebElement each : namesList) {
            if(each.getText().equalsIgnoreCase(name)){
                Assert.assertTrue(true);
                return;
            }
        }
        // Assert.fail --> will always fail the test when it is called, no matter what
        Assert.fail("Name: "+name+ " does not exist on the list, verification FAILED");

    }





    //new below

    //Create a method named printNamesAndCitiesin SmartBearUtils class.
    // •Method takes WebDriver object.
    // •This method should simply print all the names in the List of All Orders.
    // •Create a new TestNG test to test if the method is working as expected.
    // •Output should be like:
    // •Name1: name , City1: city
    // •Name2: name , City2: city


    public static void printNamesAndCities(WebDriver driver) {


        // locating all the names from all the rows and storing in a list of web element
        //this is from above utility method, the same, pogledati
        List<WebElement> namesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        //we need to locate all the cities from all the rows
        List<WebElement> citiesList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[7]"));

        for( int i=0; i<namesList.size(); i++){
            System.out.println("Name"+(i+1)+": "+ namesList.get(i).getText() + ", City"+(i+1)+": "+ citiesList.get(i).getText());
        }
    }
}
