package com.cybertek.tests.day3_cssSelector_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P2_ZeroBankVerification {
    public static void main(String[] args) {

        // TC #2: Zero Bank link text verification
        // 1.Open Chrome browser
        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();

        // we will call the method now to create "chrome driver" from "utility" package, instead of writing above 2 lines
        WebDriver driver = WebDriverFactory.getDriver("chrome");
    //   datatype  name         class         method
        // second and easy way to create Chrome driver from utility package, pogledati



        // 2.Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        // 3.Verify link text from top left:
        // Expected: “Zero Bank”
        WebElement zeroBankLinkTopLeft = driver.findElement(By.className("brand"));

        String expectedLinkText = "Zero Bank";
        String actualLinkText = zeroBankLinkTopLeft.getText();

        if(actualLinkText.equals(expectedLinkText)){
            System.out.println("Link text verif. PASSED ");
        }else{
            System.out.println("Linkl text verif. FAILED !!!");
        }

        // 4.Verify link hrefattribute value contains:
        // Expected: “index.html”
        String expectedInHref = "index.html";
        String actualHrefValue = zeroBankLinkTopLeft.getAttribute("href");

        System.out.println("actualHrefValue = " + actualHrefValue); // for better understanding
        System.out.println("expectedInHref = " + expectedInHref);

        if(actualHrefValue.contains(expectedInHref)){
            System.out.println("Href value verif. PASSED");
        }else{
            System.out.println("Hrem value verif. FAILED !!!");
        }


    }
}
