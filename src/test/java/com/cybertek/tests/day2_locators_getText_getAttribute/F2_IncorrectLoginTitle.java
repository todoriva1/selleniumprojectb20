package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class F2_IncorrectLoginTitle {
    /*
    TC #2: Facebook incorrect login title verification
    1.Open Chrome browser
    2.Go to https://www.facebook.com
    3.Enter incorrect username
    4.Enter incorrect password
    5.Verify title changed to:
     Expected: “Log into Facebook | Facebook
     */
    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        driver.findElement(By.id("email")).sendKeys("todoriva1@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("ererer23"+ Keys.ENTER);


        String expectedTitle = "Log into Facebook | Facebook";
        Thread.sleep(5000);
        String actualTitle = driver.getTitle();

        System.out.println("expectedTitle = " + expectedTitle);
        System.out.println("actualTitle = " + actualTitle);



        if(actualTitle.equals(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else{
            System.out.println("Title verification FAILED !!!");
        }
    }

}
