package com.cybertek.tests.Day8_alerts_iframes;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertsPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");


    }


    /*
TC #1: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Alert” button
4. Click to OK button from the alert
5. Verify “You successfuly clicked an alert” text is displayed.
     */

    @Test
    public void p1_information_alert_practice() {

        // locating the warning alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));

        //click to the button
        warningAlertButton.click();


        //1 - create Alert insatnce and switch to alert
        Alert alert = driver.switchTo().alert();

        BrowserUtils.wait(2); // we use this custom method we created in BrowserUtils class in Utility class

        //2 - use "alert" instance to accept the javascript alert(popup)
        alert.accept();


        //Locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));


        Assert.assertTrue(resultText.isDisplayed(), "Result text is not displayed. Verification FAILED !!!");

    }


    //new test bellow

    /*
    TC #2: Confirmation alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Confirm” button
4. Click to OK button from the alert
5. Verify “You clicked: Ok” text is displayed.
     */

    @Test
    public void p2_confirmation_alert_practices() {


        // locating the warning alert button to click it
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));

        //click to the button
        warningAlertButton.click();

        //create alert instance
        Alert alert = driver.switchTo().alert();

        //we can either accept() or dismissed() the confirmation alert
        alert.accept();
        // alert.dismiss(); can be also

        //Locating the result text web element
        WebElement resultText = driver.findElement(By.xpath("//p[@id='result']"));

        //Assert
        Assert.assertTrue(resultText.isDisplayed());

        }

}
