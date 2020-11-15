package com.cybertek.tests.day6_dropdown_review;

import com.cybertek.utilities.SmartBearUtilities;
import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {
    //TC #1:
    // Smartbear software link verification
    // 1.Open browser
    // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
    // 3.Enter username: “Tester”
    // 4.Enter password: “test”
    // 5.Click to Login button
    // 6.Print out count of all the links on landing page
    // 7.Print out each link text on this page

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        //first two step done above

        SmartBearUtilities.loginToSmartBear(driver); // this are steps 3,4,5 and they are imported from utility class, pogledati utility
    }


    @Test
    public void smartBear_link_verification() {

        // 6.Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a")); // will get all the links from web page, can be also without "body" --> ("//a")

        System.out.println("Count of all the links on the page = " + allLinks.size()); // we count all links


        // 7.Print out each link text on this page
        for(WebElement each : allLinks){
            //System.out.println(each.getText());
            System.out.println("each = " + each.getText()); // moze i ovako kao i ovo odma gore --> "each.soutv"

        }
    }


    // TEST 2:

    @Test
    public void task2_createOrderWithJavaFaker() throws InterruptedException {


        //TC#2: Smartbearsoftware order placing
        // 1.Open browser
        // 2.Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        // 3.Enter username: “Tester”
        // 4.Enter password: “test”
        // 5.Click on Login button
           // first 5 with did it in @beforeMethod already above

        // 6.Click on Order
        WebElement orderLink = driver.findElement(By.xpath("//a[@href='Process.aspx']"));
        orderLink.click();

        // 7.Select familyAlbum from product, set quantity to 2
        Select productDropdown = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
        productDropdown.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        Thread.sleep(1000);
        quantityInput.sendKeys(Keys.BACK_SPACE); // treba da oberisemo sta je pisalo predhodno u zagradi

        Thread.sleep(1000);
        quantityInput.sendKeys("2"); // i onda unesemo vrednost "2"

        // 8.Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.className("btn_dark"));
        calculateButton.click();


        // locating all of the web elements using id
        WebElement nameInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        // 9.Fill address Info with JavaFaker•Generate: name, street, city, state, zip code
        Faker faker = new Faker();
        //generate: name,street,city,state,zip code
        nameInput.sendKeys(faker.name().fullName());
        streetInput.sendKeys(faker.address().streetAddress());
        cityInput.sendKeys(faker.address().city());
        stateInput.sendKeys(faker.address().state());
        zipInput.sendKeys(faker.address().zipCode());


        // 10.Click on “visa” radio button
        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visaRadioButton.click();

        // 11.Generate card number using JavaFaker
        WebElement creditCardInput = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        creditCardInput.sendKeys(faker.finance().creditCard().replace("-",""));

        // enter expiration date
        WebElement expirationDate = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDate.sendKeys("12/25");

        // 12.Click on “Process”
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        processButton.click();

        // 13.Verify success message “New order has been successfully added.”

        String expectedResult = "New order has been successfully added.";
        String actualResult = driver.findElement(By.xpath("//Strong")).getText();

        Assert.assertEquals(actualResult,expectedResult); // true




    }



}
