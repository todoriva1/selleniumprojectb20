package com.cybertek.tests.day2_locators_getText_getAttribute;
/*
#2: Cybertek verifications
1.Open Chrome browser
2.Go to https://practice.cybertekschool.com
3.Verify URL containsExpected: cybertekschool
4.Verify title: Expected: Practice
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize(); // ako hocemo,nije da mora

        driver.get("http://practice.cybertekschool.com");

        String expectedURL = "cybertekschool";
        String actualURL = driver.getCurrentUrl();// driver is connected to the browser

        if(actualURL.contains(expectedURL)){
            System.out.println("PASSED !");
        }else{
            System.out.println("FAILED !");
        }

        if(driver.getTitle().equals("Practice")){
        //  actual title            expected title
            System.out.println("PASSED !!!");
        }else{
            System.out.println("FAILED !!!");
        }




    }
}
