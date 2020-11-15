package com.cybertek.utilities;
/*
    TASK: NEW METHOD CREATION

        Method name: getDriver
        Static method
        Accept string argument: browserType --> will determine what browser opens
             -->If "chrome" opens chrome browser
             -->If "firefox" opens firefox browser
        return type: WebDriver
     */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public static WebDriver getDriver(String browserType){

        if(browserType.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else{
            System.out.println("given browser does not exist. Driver = null");
            return null;
        }
    }

}
