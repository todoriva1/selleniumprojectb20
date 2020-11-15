package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F1_FacebookTitleVerification {
    public static void main(String[] args) {
        /*
        TC #1: Facebook title verification1.Open Chrome browser
        2.Go to https://www.facebook.com
        3.Verify title:
        Expected: “Facebook -Log In or Sign Up"
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");



        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Verification PASSED");
        }else{
            System.out.println("Verification FAILED");
        }
    }
}
