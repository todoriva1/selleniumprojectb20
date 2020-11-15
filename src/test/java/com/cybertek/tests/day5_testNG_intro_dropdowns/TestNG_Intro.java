package com.cybertek.tests.day5_testNG_intro_dropdowns;


import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class run");
    }


    @AfterClass
    public void tearDownClass(){
        System.out.println("After class run");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running !!!!"); //run before each method, so 2 times here for example
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method running");
    }


    @Test
    public void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
    public void test2(){
        System.out.println("Test2 is running...");
    }

    @Test
    public void test3(){
        String str1 = "testNG";
        String str2 = "testNG";
        String str3 = "fsfdsdd";


        Assert.assertTrue(str1.equals(str2)); // true
        Assert.assertTrue(str1.equals(str3),"str1 is not equal to str3");  // we can write message like this to know where exactly is problem. THIS MESSAGE ONLY APPEAR IF CONDITION FAIL, otherwise will not display
                                            // so above will failed, and below will not be executed,

        Assert.assertEquals(str1,str2,"Failure message just in case str1 is not equal to str2"); // expecting 2 arguments always
    }







}

