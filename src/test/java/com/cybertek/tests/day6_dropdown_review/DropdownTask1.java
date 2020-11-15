package com.cybertek.tests.day6_dropdown_review;
/*
//TC #2: Selecting state from State dropdown and verifyingresult
    // 1.Open Chrome browser
    // 2.Go to http://practice.cybertekschool.com/dropdown
    // 3.Select Illinois
    // 4.Select Virginia
    // 5.Select California
    // 6.Verify final selected option is California.Use all Select options.(visible text, value, index)
 */

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTask1 {


    WebDriver driver; // we created here instance "driver" that we can use it later. Otherwise will be local inside body bellow

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void test2_verify_state_dropdown() throws InterruptedException{
        //we need to locate first the dropdown
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        // 3.Select Illinois
        Thread.sleep(1000);
        stateDropdown.selectByVisibleText("Illinois");

        // 4.Select Virginia
        Thread.sleep(1000);
        stateDropdown.selectByValue("VA");

        // 5.Select California
        Thread.sleep(1000);
        stateDropdown.selectByIndex(5);

        // 6.Verify final selected option is California.
        String expectedResult = "California";
        String actualResult = stateDropdown.getFirstSelectedOption().getText(); // we need .getText because return type is webElement without .getText

        Assert.assertEquals(actualResult,expectedResult, "Actual and Expected are not equal");

        // Use all Select options.(visible text, value, index)
    }



    //TEST 2:

    @Test
    public void test3_date_dropdown_verification(){

        //TC #3: Selecting date on dropdown and verifying
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // we handle this first 2 steps in @before mothod above

        //locate webElement (dropdown)
        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        //creating expected values in one place
        String expectedYear = "1921";
        String expectedMonth = "December";
        String expectedDay = "1";

        // 3.Select “December 1st, 1921” and verify it is selected.
        //    Select year using: visible text
        yearDropdown.selectByVisibleText("1921");
        //    Select month using : value attribute
        monthDropdown.selectByValue("11");
        //    Select day using: index number
        dayDropdown.selectByIndex(0);

        //getting our actual values from the web page
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        //creating assert lines to compare actual vs expected
        Assert.assertEquals(actualYear,expectedYear,"Actual year not equal with expected year"); // expect 2 arguments -> assertEquals
        Assert.assertEquals(actualMonth,expectedMonth, " Actual month not equal with expected month");
        Assert.assertTrue(actualDay.equals(expectedDay),"Actual day not equal with expected day"); // expect boolean -> assertTrue
    }


    // TEST 4:

    @Test
    public void test4_multiple_value_select_dropdown() {

        // TC #4: Selecting value from multiple select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // this above is already did in @before method


        // 3.Select all the options from multiple select dropdown.
        //locate dropdown first
        Select multipleSelectDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));

        //creating a list of web elements to store the all options from this dropdown
        List<WebElement> allOptions = multipleSelectDropdown.getOptions();

        //loop through the option to select all of them
        // 4.Print out all selected values.
        for (WebElement each : allOptions) {
            each.click(); // each option with every iteration
            System.out.println("selected: " + each.getText());// print each option

            // Asserting the options is actuallyselected or not
            Assert.assertTrue(each.isSelected(), "The option: " + each.getText() + " is not selected");
        }
        // 5.Deselect all values.
        multipleSelectDropdown.deselectAll();

        for (WebElement each : allOptions) {
            Assert.assertTrue(!each.isSelected()); // true beacuse we passed "!"

            Assert.assertFalse(each.isSelected()); // the same as assertTrue, gives true on the end
        }
    }

        // TEST 5:

        @Test
         public void test5_html_dropdown_handling(){

        //TC #5: Selecting value from non-select dropdown
        // 1.Open Chrome browser
        // 2.Go to http://practice.cybertekschool.com/dropdown
        // we did it already in @beforeMethod above


            //locate html dropdown as a regular web element
            WebElement websiteDropdown = driver.findElement(By.xpath("//div[@class='dropdown']/a")); // locating from parent

            //3.Click to non-select dropdown
            websiteDropdown.click();

            // 4.Select Facebook from dropdown
            WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));
            facebookLink.click();

            // 5.Verify title is “Facebook -Log In or Sign Up”
            String actualTitle = driver.getTitle();
            String expectedTitle = "Facebook - Log In or Sign Up";

            Assert.assertEquals(actualTitle,expectedTitle); // we didn't put additional message inside ( )  as usual
    }



}
