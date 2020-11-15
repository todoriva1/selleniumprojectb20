package com.cybertek.tests.Day9_Windows_Tabs;

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

public class Alert3Practice {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }
    /*
    TC #3: Information alert practice
1. Open browser
2. Go to website: http://practice.cybertekschool.com/javascript_alerts
3. Click to “Click for JS Prompt” button
4. Send “hello” text to alert
5. Click to OK button from the alert
6. Verify “You entered: hello” text is displayed.
     */

    @Test
    public void prompt_alert_practice(){
        WebElement promptAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptAlertButton.click();

        //Using Alert class to handle alert
        Alert alert = driver.switchTo().alert();

        //BrowserUtils class from Utility class
        BrowserUtils.wait(2);

        //Sending keys to the "prompt" alert
        alert.sendKeys("Something is happening");

        alert.accept();

        WebElement resultText = driver.findElement(By.id("result"));

        Assert.assertTrue(resultText.isDisplayed(),"The result text is not displayed. Verification Failed !!");










    }



}
