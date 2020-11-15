package com.cybertek.tests.Day7_WebTables;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Smartbear_software_order_verif {
    //TC#3: Smartbear software order verification
    // 1.Open browser and login to Smartbear software
    // 2.Click on View all orders
    // 3.Verify Susan McLaren has order on date “01/05/2010”

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
       driver = WebDriverFactory.getDriver("chrome");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

       SmartBearUtilities.loginToSmartBear(driver); // from utilities class, pogledati
    }

    @Test
    public void verify_susans_order_date(){

        WebElement SusansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']//following-sibling::td[3]"));

        System.out.println("SusansDate = " + SusansDate.getText()); // we need .getText  --> to get as a String

        String expectedDate = "01/05/2010";
        String actualDate = SusansDate.getText();

        Assert.assertTrue(expectedDate.equals(actualDate));
        //a moze i ovako
        Assert.assertEquals(expectedDate,actualDate);


    }



}
