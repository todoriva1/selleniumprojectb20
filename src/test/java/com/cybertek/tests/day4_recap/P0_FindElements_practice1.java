package com.cybertek.tests.day4_recap;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
// here we practice find ElementS (plural)

public class P0_FindElements_practice1 {
    public static void main(String[] args) {


       //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Print out the texts of all links
            // shortcut to introduce the local variable: : option + enter
        //locating all the links on the page and storing them into a list of WebElements
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a")); // list of web elements
        //  it is "//a" because if we use all links with "a" , and sinle / will looking for child only

        //Looping through the list of WebElement we just created above
        for(WebElement eachLink: listOfLinks){

            //Getting the text of each elements in each iteration and printing the values
            System.out.println(eachLink.getText());
        }

        // 4.Print out how many total link
        int numberOfLinks = listOfLinks.size();
        System.out.println("numberOfLinks = " + numberOfLinks);


    }
}
