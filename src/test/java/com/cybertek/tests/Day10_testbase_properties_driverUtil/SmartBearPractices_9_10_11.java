package com.cybertek.tests.Day10_testbase_properties_driverUtil;
/*
TC #9: SmartBear delete order
1. Open browser and login to SmartBear
2. Delete “Mark Smith” from the list
3. Assert it is deleted from the list



TC #10: SmartBear edit order
1. Open browser and login to SmartBear
2. Click to edit button from the right for “Steve Johns”
3. Change name to “Michael Jordan”
4. Click Update
5. Assert “Michael Jordan” is in the list



TC #11 : Create a method called removeName()
1. Accepts two parameters: WebDriver, String name
2. Method will remove the given name from the list of Smartbear
3. Create a new TestNG test, and call your method.
4. Assert that your method removed the given name
 */

import com.cybertek.tests.Base.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.SmartBearUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase {  // pogledati TestBase abstract class
    /*
    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

     */

    /*
    TC #9: SmartBear delete order
    1. Open browser and login to SmartBear
    2. Delete “Mark Smith” from the list
    3. Assert it is deleted from the list
     */

    @Test
    public void Practice_9_DeleteOrderTask () throws IOException {

        //creating properties object to be able to read properties file
        Properties properties = new Properties();

        //opening the file in JVM memory using FileInputStream
        FileInputStream file = new FileInputStream("configuration.properties");

        //Loading the file into properties object
        properties.load(file);

        //url from configuration properties
        String url = properties.getProperty("smartbearUrl");// return url from configuration properties

        // above four lines are from configuration.property file  --> pogledati


        driver.get(url); // now we use this string "url" from above code fragment
        SmartBearUtilities.loginToSmartBear(driver);


        //locate the checkbox for "Mark Smith" and click to it
        WebElement markSmithCheckbox = driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        markSmithCheckbox.click();
        BrowserUtils.wait(1);

        //locate "Delete Selected" button and click to it
        WebElement deleteButton = driver.findElement(By.id("ctl00_MainContent_btnDelete"));
        deleteButton.click();

        //Assert " Mark Smith" is not in the table
        List <WebElement> nameList = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for(WebElement each : nameList){
            Assert.assertFalse(each.getText().equals("Mark Smith"));// we check all names to make sure Mark Smith is not there
            // we use assertFalse because we expect to be False !
        }




    }


}












