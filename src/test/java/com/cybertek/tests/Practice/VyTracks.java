package com.cybertek.tests.Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTracks {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://qa2.vytrack.com");

        driver.findElement(By.id("prependedInput")).sendKeys("user171"+ Keys.ENTER);
        driver.findElement(By.id("prependedInput2")).sendKeys("useruser123"+ Keys.ENTER);



    }
}
