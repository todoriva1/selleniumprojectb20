package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P4_GoogleSearch {
    public static void main(String[] args) {

        //	set up browser driver
        WebDriverManager.chromedriver().setup();

        //1-Open	a	chrome	browser
        WebDriver driver = new ChromeDriver();

        //2-Go	to:	https://google.com
        driver.get("https://www.google.com");

        //3-Write	“apple”	in	search	box,  need to locate search box in order to write
        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER); // "q" is the tag name when right click on google search window


        //4-Click	google	search	button - we did this Keys.ENTER already
        //5-Verify	title:
        //Expected:	Title	should	start	with	“apple”
        String expectedTitle = "apple - Google Search";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTitle)){ // can be instead od "equal" - "start with"
            System.out.println("Search title verification PASSED !");
        }else{
            System.out.println("Search title verification FAILED !");
        }


    }
}
