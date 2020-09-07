package com.cybertek.tests.day2_locators_getText_getAttribute;
/*
TC #1: Google Title Verification
1.Open Chrome browser
2.Go to https://www.google.com
3.Verify title: Expected: GoogleTC
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup(); // we set up browser
        WebDriver driver = new ChromeDriver();  // we created instance of the chrome driver, open empty browser for us
        driver.get("http://google.com"); // open the google browser

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED !");
        }else{
            System.out.println("Title verification FAILED !");
        }






    }
}
