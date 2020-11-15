package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class P05_SeleniumEasy_Task1 {
    public static void main(String[] args) throws InterruptedException {
        //TC	#2:	SeleniumEasy	CheckboxVerification–Section	1
        // 1.Open	Chrome	browser
        // 2.Go	to	https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // locate success mesaage and check box under "single checkbox demo"
        WebElement successCheckbox = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));

        //locate success message
        //create a locator to success message and share it in a class chat
        WebElement succesMessage = driver.findElement(By.xpath("//div[@id='txtAge']"));


        // 3.Verify	“Success – Check box is	checked”	message	is	NOTdisplayed.
        if( ! succesMessage.isDisplayed()){ // opposite condition
            System.out.println("Success message in NOT display, verification PASSED");
        }else{
            System.out.println("Success message in display, verification FAILED");
        }


        // 4.Click	to	checkbox	under	“Single	Checkbox	Demo”	section
        successCheckbox.click();



        // 5.Verify	“Success – Check box is checked” message is displayed
        if(successCheckbox.isSelected()  &&  succesMessage.isDisplayed()){
            System.out.println("Checkbox is checked, verification PASSED");
        }else{
            System.out.println("Checkbox is NOT checked, verification FAILED !!!");
        }


        Thread.sleep(3000);
        driver.close();




    }
}
