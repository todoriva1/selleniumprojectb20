package com.cybertek.tests.Practice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC1_CybertekForgotPassword {
    /*
    TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
           1. Open Chrome browser
           2. Go to http://practice.cybertekschool.com/forgot_password
           3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)

           a. “Home” link
           b. “Forgot password” header
           c. “E-mail” text
           d. E-mail input box
           e. “Retrieve password” button
           f. “Powered by Cybertek School” text

           4. Verify all WebElements are displayed.
     */

    public static void main(String[] args) {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
           WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
           System.out.println("homeLink = " + homeLink.isDisplayed()); // true
           System.out.println("homeLink = " + homeLink.getText()); // ne mora,ali da vidimo sta pise kad stavimo getText

        // WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
           WebElement forgotPassword = driver.findElement(By.cssSelector("div.example"));
           System.out.println("forgotPassword = " + forgotPassword.isDisplayed());

           // WebElement email = driver.findElement(By.xpath("//label[@for='email']"));
              WebElement email = driver.findElement(By.cssSelector("label[for='email']"));
              System.out.println("email = " + email.isDisplayed());

           //WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));
             WebElement emailInput = driver.findElement(By.xpath("//input[@type='text']"));
             System.out.println("emailInput = " + emailInput.isDisplayed());

           //WebElement retrieveButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
             WebElement retrieveButton = driver.findElement(By.cssSelector("button[id='form_submit']"));
             System.out.println("retrieveButton = " + retrieveButton.isDisplayed());

           //WebElement powerByCyberSchool = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
             WebElement powerByCyberSchool = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
             System.out.println("powerByCyberSchool = " + powerByCyberSchool.isDisplayed());


             if(homeLink.isDisplayed()  &&  forgotPassword.isDisplayed()  &&  email.isDisplayed()  &&  emailInput.isDisplayed()  &&
                retrieveButton.isDisplayed()  &&  powerByCyberSchool.isDisplayed()){
                 System.out.println("Verification PASSED !");
             }else{
                 System.out.println("Verification FAILED !!!!!");
             }

           //  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) --> samo primer,nema veze sa taskom


    }
}
