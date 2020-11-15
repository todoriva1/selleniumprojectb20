package com.cybertek.tests.Day9_Windows_Tabs;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandlingPractices {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/windows");
    }

    /*
    TC # : Window Handle practice
1. Create a new class called: WindowHandlePractice
2. Create new test and make set ups
3. Go to : http://practice.cybertekschool.com/windows
4. Assert: Title is “Practice”
5. Click to: “Click Here” text
6. Switch to new Window.
7. Assert: Title is “New Window”
     */

    @Test
    public void windowHandle() {

        driver.get("http://practice.cybertekschool.com/windows");
        String actualTitle = driver.getTitle();
        System.out.println("actualTitle = " + actualTitle);

        Assert.assertTrue(actualTitle.equals("Practice"));

        WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
        clickHereLink.click();

        String titleAfterClick = driver.getTitle();
        System.out.println("titleAfterClick = " + titleAfterClick);


        String mainHandle = driver.getWindowHandle();
        System.out.println("mainHandle = " + mainHandle);

        //Set allows only unique values
        // option + enter for mac shortcut to generate bellow
        Set<String> windowHandles = driver.getWindowHandles();
        // we loop through the set of window handles so that we can get the window handle of the other window
        //then using switchTo().window() method we switch to the other window

        for (String each : windowHandles) {
            driver.switchTo().window(each);
            System.out.println("Current title= " + driver.getTitle());
            System.out.println("Current WINDOW HANDLE = " + driver.getWindowHandle()); // here we see current window handle
        }

        // getting the current title, and comparing with expected title
        Assert.assertTrue(driver.getTitle().equals("New Window"));

        BrowserUtils.wait(2);
        driver.close(); // close current focus window
        // driver.quit(); this will close all of the tabs

        //if I want to switch back to main window to continue
        driver.switchTo().window(mainHandle);
    }




        // new task

    /*
    TC-6 : Window Handle practice

Create new test and make set ups
Go to : https://www.amazon.com
Copy paste the lines from below into your class
Create a logic to switch to the tab where Etsy.com is open
Assert: Title contains “Etsy”

     */

        @Test
        public void handling_more_then_two_windows(){
        driver.get("https://www.amazon.com");

            // this lines are: basically we are downcasting our driver type to JavaScriptExecutor
            // The only things this lines doing is using JS executor -> opening new tabs with given links
            ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
            ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

            Set<String> windowHandles = driver.getWindowHandles();
            //Amazon
            //Facebook
            //Etsy

            for(String each : windowHandles){

                driver.switchTo().window(each);
                if(driver.getCurrentUrl().contains("etsy")){
                    Assert.assertTrue(driver.getTitle().contains("etsy"));
                    break;
                }
            }



        }




}
