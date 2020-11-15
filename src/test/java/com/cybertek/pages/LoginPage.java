package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/*
We store all the web elements and methods related to LoginPage in this . java class
 */

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);   // we called this method from PageFactory, coming from selenium
                                                        // "this" is object and is creating connection with driver and object class
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInput; // this how we locate webElement now


    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInput;

    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    @FindBy(id = "ctl00_MainContent_status" )  // if we put incorrect username or pass, display this message
    public WebElement errorMessage;

    public void login(String username, String password){
       usernameInput.sendKeys(username);
       passwordInput.sendKeys(password);
       loginButton.click();
    }





}
