package com.cybertek.tests.Practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTruck_Assign3 {
    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void logInFunctionality() throws InterruptedException {
        Thread.sleep(1500);

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("user171");

        Thread.sleep(1500);

        WebElement password = driver.findElement((By.cssSelector("input[placeholder='Password'")));
        password.sendKeys("UserUser123"+ Keys.ENTER);


        String expectedTitle = "Dashboard";
        String actualTitle = driver.getTitle();

        System.out.println("actualTitle = " + actualTitle);

        Assert.assertEquals(expectedTitle,actualTitle,"Expected Title DID NOT match Actual Title");


    }
    
    @AfterMethod
    public void methodShutDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
