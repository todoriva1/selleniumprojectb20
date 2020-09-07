package com.cybertek.tests.day3_cssSelector_xpath;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WT_CybertekLinkVerification {
    public static void main(String[] args) {
        //TC #3: PracticeCybertek/ForgotPassword URL verification
        // 1.Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Enter any email into input box
       // driver.findElement(By.name("email")).sendKeys("anyemail@domain.com");
       WebElement emailInputBox = driver.findElement(By.name("email"));  // better like this,reusabililty, easy to maintain
       emailInputBox.sendKeys("anyemail@domain.com");

        // 4.Click on Retrieve password
        //driver.findElement(By.id("form_submit")).click();
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit")); // the same like above. Easy if we create variable like this
        retrievePasswordButton.click();


        // 5.Verify URL contains:
        //  Expected: “email_sent”
        String expectedInURL = "email_sent";
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedInURL)){
            System.out.println("URL verification PASSED");
        }else{
            System.out.println("URL verification FAILED");
        }
        // 6.Verify textbox displayed the content as expected.
        // Expected: “Your e-mail’s been sent!”Hint:


        //verify the text
        // mac book short cut for "string actual result":

        //String actualText = driver.findElement(By.name("confirmation_message")).getText();
        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message")); // better this way then right above. Easy to be readable, reusable...

        String actualText = confirmationMessage.getText();
        String expectedText = "Your e-mail's been sent!";

        System.out.println("actualText = " + actualText); // we do this to check the result if failed. Because some character is different like " ' " is different then actual result
        System.out.println("expectedText = " + expectedText);
        // we printed this 2 above value to see what is the different



        if(actualText.equals(expectedText)){
            System.out.println("header text value verif. PASSED !!");
        }else{
            System.out.println("header text value verif. FAILED !!");
        }
        //verify if the web element is displayed or not
        if(confirmationMessage.isDisplayed()){
            System.out.println("Confirmation message is displayed");
        }else{
            System.out.println("Confirmation message is NOT displayed");
        }

        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D
        // HOW TO MULTIPLY LINE :  COMMAND + D

    }
}
