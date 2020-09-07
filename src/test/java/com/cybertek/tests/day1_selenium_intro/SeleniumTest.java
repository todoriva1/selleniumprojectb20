package com.cybertek.tests.day1_selenium_intro;
// prvi dan Selenium,prvi cas
// danas je 22.avgust 2020

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args)   throws InterruptedException{ // ovo smo dodali da bi mogli da izadjemo iz programa dole "Thread.sleep"

        //1- set up the web driver
        WebDriverManager.chromedriver().setup(); // or we can do it by "System.setProperty"


        //2- create the instance of the chrome driver
        WebDriver driver = new ChromeDriver(); // open blank browser


        //3- test if driver instance is working
        driver.get("https://www.google.com");
        // .get  method: accept String as a parameter

       // System.out.println("the title of the page is: "+ driver.getTitle()); // does not accept any parameter, return title of the page as a String

        String actualTitle = driver.getTitle(); // moze i ovako
        System.out.println("Actual title string: "+actualTitle);




        // novi method dole
        String actualURL = driver.getCurrentUrl(); // return the current URL value as a String
        // does not accept any argument

        System.out.println("actualURL = " + actualURL);


        //novi method
        Thread.sleep(2000); // command wait for 2 seconds and continue,we need to put first next to the main method

        driver.navigate().back(); // like we click back button on google for example,get to the previous page
        Thread.sleep(3000);// wait 3 seconds. open browser,wait 3 second ang back

        driver.navigate().forward();// like click forward on google
        Thread.sleep(3000);// the same

        driver.navigate().refresh();// like refresh button on google
        Thread.sleep(3000); // wait 3 second

        driver.navigate().to("https://www.facebook.com"); // and after all wait 3 seconds navigate to facebook
        // .to method require argument
        // similar to "get method"  - wait for page to load
        // "to method" - do not wait page to load.



        //novi method
        driver.getPageSource(); // return the page source as String, like inspect element
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



        //novi method
        driver.manage().window().maximize();
        // make your browser maximized on whole screen
        driver.manage().window().fullscreen(); // work only on mac


        //novi method
        driver.close();// just closes the last opened window of the browser, last brwoser only

        driver.quit(); // quit method,closes all the browser open in that session


    }

}
