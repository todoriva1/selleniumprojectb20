package com.cybertek.tests.Day13_pom_synchronization;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest_SB {


    @Test (description = "enetering incorrect username") // (description = "enetering incorrect username") not necessary to add,it is optional
    public void negative_login_test1(){
        String url = ConfigurationReader.getProperty("smartbearUrl"); // // from utility ConfigurationReader
        Driver.getDriver().get(url);


        //let's start using PageObjectModel


        //#1 - We want to create the object of the class we want to use
        LoginPage loginPage = new LoginPage();
        //When we create the instance of this class, the constructor immediately initialize our Driver and the object 'loginPage'

        //#2 - Call the object to use the web elements
        //Entering inccorect username
        loginPage.usernameInput.sendKeys("saassd");

        //Enter correct password
        String password = ConfigurationReader.getProperty("smartbear_password");
        loginPage.passwordInput.sendKeys(password);

        //click to login button
        loginPage.loginButton.click();

        // Assert true that error message is display on the page
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"error message is not displayed, verification failed !!!");

    }




    // new test below

    @Test (description = "using login method for negative test")
    public void negative_login_test2(){
        String url = ConfigurationReader.getProperty("smartbearUrl");
        Driver.getDriver().get(url);

        LoginPage loginPage = new LoginPage();
        String username = "weijier";
        String password = ConfigurationReader.getProperty("smartbear_password");

        loginPage.login(username,password); // login method is from LoginPage class in Page package, it is the same as previous test
        // just here is difference is that we use this method. It is easier
        // Assert true that error message is display on the page
        Assert.assertTrue(loginPage.errorMessage.isDisplayed(),"error message is not displayed,verification failed !!!");




    }






}
