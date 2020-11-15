package com.cybertek.tests.Day8_alerts_iframes;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    //TC#7: Cybertek “month” dropdown default value
    //1. Open browser
    //2. Go to website: http://practice.cybertekschool.com/dropdowns
    //3. Verify default value is always showing the current month
    //4 Expected: If currently in June, should show June selected.


    @Test
    /*
    TC#7: Cybertek “month” dropdown default value
        1. Open browser
        2. Go to website: http://practice.cybertekschool.com/dropdowns
        3. Verify default value is always showing the current month
        o Expected: If currently in June, should show June selected.

     */

    public void p7_dropDown(){

        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));

        //Expected
       // String expectedValue = "September";  --> now work like that,we need dynamic approach, like this below
        String expectedValue = LocalDateTime.now().getMonth().name();
        System.out.println("expectedValue = " + expectedValue);


        //Actual
        String actualValue = monthDropdown.getFirstSelectedOption().getText();
        System.out.println("actualValue = " + actualValue);


        //Assert
        Assert.assertEquals(actualValue.toLowerCase(),expectedValue.toLowerCase());
        //first time to use this,we use lowerCase method for both actual and expected value

        Assert.assertTrue(actualValue.equalsIgnoreCase(expectedValue));
        //second way we use here to compare expected vd actual value
        //we use 2 same assertion here in 2 different ways, but the same




        //new task 8:
        /*
        TC#8: Cybertek “month” dropdown list of default values verification
               1. Do both verifications in the same test
               2. Verify list of months are correct as expected.
               o Expected: Options should contain all 12 months of the year.

         */

        //This line below gets all of the option from dropdown and store the value in a list
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        //created a list of strings to store months
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "August","September","October", "November", "December");

        //Create a new list of Strings called: actualMonthsTexts , and store the texts of web elements into this new list
        /*
        List<String> actualMonthsTexts = new ArrayList<>();

        for(WebElement each : actualMonthOptions) {
            actualMonthsTexts.add(each.getText());
        }
         */

        BrowserUtils.wait(2); // from BrowserUtils class method,better then below
        //Thread.sleep(2000);

        //moze ovako gore,a moze i preko BrowserUtils class da se ubaci u Assertion dole, pogledati
        Assert.assertEquals(BrowserUtils.getElementsText(actualMonthOptions), expectedMonthOptions);
    }




    }







