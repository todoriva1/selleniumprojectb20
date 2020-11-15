package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F4_HeaderVerification2 {
    /*
       TC #4: Facebook header verification
       1.Open Chrome browser
       2.Go to https://www.facebook.com
       3.Verify “Create a page” link href value contains text:
        Expected: “registration_form”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedAttribute = "registration_form";
        String actualAttribute = driver.findElement(By.linkText("Create a Page")).getAttribute("href");

        System.out.println("expectedAttribute = " + expectedAttribute);
        System.out.println("actualAttribute = " + actualAttribute);

        if(actualAttribute.contains(expectedAttribute)){
            System.out.println("Attribute value verification PASSED");
        }else{
            System.out.println("Attribute value verification FAILED");
        }
    }
}
