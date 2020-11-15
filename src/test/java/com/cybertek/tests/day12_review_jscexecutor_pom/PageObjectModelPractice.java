package com.cybertek.tests.day12_review_jscexecutor_pom;

import com.cybertek.pages.LoginPage;
import org.testng.annotations.Test;

public class PageObjectModelPractice {

    @Test
    public  void login_to_smartbear(){
        LoginPage loginPage = new LoginPage();
        // get url --> smartbear

        loginPage.usernameInput.sendKeys("anyusername");


    }

}
