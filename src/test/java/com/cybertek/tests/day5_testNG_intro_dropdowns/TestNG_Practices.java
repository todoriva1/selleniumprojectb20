package com.cybertek.tests.day5_testNG_intro_dropdowns;

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

public class TestNG_Practices {

    WebDriver driver; // we need here instance variable, outside of any method,and we can use it later

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("https://www.google.com"); // here is because every test will launch google first
    }


    @Test
    public void googleTitleVerification(){



        //2. - Verify title is google
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle,"Title are not matched");

    }

    @Test
    public void googleSearchTitleVerification(){
        // go to google --> this part will be taken care of in the beforeMethod

        // search apple
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("apple"+ Keys.ENTER);

        //make sure title contain apple
        String expectedResult = "apple";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedResult),"Title do not contain search value");

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
}
