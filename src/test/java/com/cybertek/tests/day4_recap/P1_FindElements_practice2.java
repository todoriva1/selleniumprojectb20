package com.cybertek.tests.day4_recap;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P1_FindElements_practice2 {
    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        // 2.Go to https://www.merriam-webster.com/
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.merriam-webster.com");


        // 3.Print out the texts of all links
            // locating all of the web elements on the page and storing in a list of WebElements
        List<WebElement> listOfLinks = driver.findElements(By.xpath("//body//a"));

        int linksWithoutText = 0;
        int linkWithText = 0;

        for(WebElement eachLink : listOfLinks){
            String textOfEachLink = eachLink.getText();

            System.out.println(textOfEachLink);

            if(textOfEachLink.isEmpty()){
                linksWithoutText++;
            }else{
                linkWithText++;
            }
        }


        System.out.println("linkWithText = " + linkWithText);

        // 4.Print out how many link is missing text
        System.out.println("linksWithoutText = " + linksWithoutText);


        // 5.Print out how many link has text
        System.out.println("linkWithText = " + linkWithText);


        // 6.Print out how many total link
        System.out.println("Total links: " + listOfLinks.size());


    }


}
