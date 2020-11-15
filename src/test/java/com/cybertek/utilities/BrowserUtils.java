package com.cybertek.utilities;
/*
In this class we will store utility method that can be applied to any browser content.
Any time you feel like you have good logic that you can use in the future,
create a method of it and store it in this class.

Than call it in the future to use it
 */

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {

    /*
    Accept a list of Web Element
    @param List<WebElement>
    @return List<String>
    Method should be returning a list of Strings
     */

    public static List<String> getElementsText(List<WebElement> list){

        List<String> webelementsAsString = new ArrayList<>();

        for (WebElement each : list) {
            webelementsAsString.add(each.getText());
        }
        return webelementsAsString;

    }



    /*
    Create a utility method named: wait
    static method
    @param sec
    @return void
    The integer number that I pass as parameter should be accepted as SECONDS
    Handle checked exception with try/catch
     */
    public static void wait(int sec){
        try{
            Thread.sleep(1000 * sec); // second will multiply with 1, and always we will have second we want
        }catch(InterruptedException e) {
            System.out.println("Interupted exception caught");
        }
    }




}
