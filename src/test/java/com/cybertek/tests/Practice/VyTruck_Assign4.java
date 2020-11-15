package com.cybertek.tests.Practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VyTruck_Assign4 {

    WebDriver driver;

    @BeforeMethod
    public void setUpDriver(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void logIn_And_vehicleOdometarTitle_verification() throws InterruptedException {

        Thread.sleep(1000);
        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("user171");

        Thread.sleep(1000);
        WebElement password = driver.findElement((By.cssSelector("input[placeholder='Password'")));
        password.sendKeys("UserUser123");

        Thread.sleep(1000);
        WebElement logInButton = driver.findElement(By.id("_submit"));
        logInButton.click();

        WebElement fleetButton = driver.findElement(By.xpath("//span[@class='title title-level-1']//i"));
        fleetButton.click();


    }


}
