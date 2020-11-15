package com.cybertek.tests.day12_review_jscexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JavaScriptExecutor_Practices {

    @Test
    public void scroll_using_jsexecutor_1(){
        //get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/infinite_scroll");

        //create instance of JSExecutor and cast our driver to it
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver(); // downcasting

        //use execute script method
        for(int i = 0; i< 10; i++) {
            BrowserUtils.wait(1); // scroll down by waiting 1 second
            js.executeScript("window.scrollBy(0,1000)"); // this coming from javascript language, scrolling down
        }


    }

    // another example of scrolling below
    @Test
    public void scroll_using_jsexecutor_2() {
        // get the page to scroll
        Driver.getDriver().get("http://practice.cybertekschool.com/large");

        //locating "cybertek school" link
        WebElement cyberteklink = Driver.getDriver().findElement(By.linkText("Cybertek School"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        //use js executor to scroll 'Cybertek School' link intoView
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //use scrollIntoView function from JavaScript to scroll to a specific web element
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", cyberteklink); // give me the first argument [0] from the link --> going down all the way
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].scrollIntoView(true)", homeLink); // return to top

    }

        // novi test i primer dole

        @Test
        public void fill_form_using_javascript(){
            Driver.getDriver().get("http://practice.cybertekschool.com/sign_up");

            WebElement usernameInput = Driver.getDriver().findElement(By.name("full_name"));
            WebElement emailInput = Driver.getDriver().findElement(By.name("email"));
            WebElement signUpbutton = Driver.getDriver().findElement(By.name("wooden_spoon"));

            BrowserUtils.wait(1);

            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

            //sending keys to usernameInput using JavaScript function .setAttribute
            js.executeScript("arguments[0].setAttribute('value', 'Jane Doe')", usernameInput);
                                        // value that exist will be replace with Jane Doe instead, and put into usernameInput

            BrowserUtils.wait(1);
            //sending keys to emailInput using JavaScript function .setAttribute
            js.executeScript("arguments[0].setAttribute('value', 'something@gmail.com')", emailInput);

            BrowserUtils.wait(1);
            //clicking to signUpbutton using JavaScript function
            js.executeScript("arguments[0].click()", signUpbutton);








    }


}
