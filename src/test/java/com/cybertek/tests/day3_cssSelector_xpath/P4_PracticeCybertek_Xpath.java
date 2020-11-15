package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_PracticeCybertek_Xpath {
    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://www.amazon.com");

        WebElement locirajSome = driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[2]"));  // ovo je vezba samo
        locirajSome.click(); // nebitno je ovo, vezbam u practice package
    }
}
