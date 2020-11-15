package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F3_HeaderVerification {
    /*
    TC #3: Facebook header verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Verify header text is as expected:
    Expected: “Connect with friends and the world around you on Facebook.”
     */

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        String expectedHeaderText = "Connect with friends and the world around you on Facebook.";
        String actualHeaderText = driver.findElement(By.className("_8eso")).getText();

        //System.out.println("expectedHeaderText = " + expectedHeaderText);
       // System.out.println("actualHeaderText = " + actualHeaderText);

        if(actualHeaderText.equals(expectedHeaderText)){
            System.out.println("Verification Header Text PASSED");
        }else{
            System.out.println("Verification Header Text FAILED !!!");
        }



    }
}
