package com.cybertek.tests.day4_recap;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Checkbox_Practice {
    public static void main(String[] args) throws InterruptedException{

        //Practice:	Cybertek	Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        // first: locating first checkbox
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        // second: locating the second checkbox
        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));


        // 2. then Confirm	checkbox	#1	is	NOT	selected	by	default
        if(! checkbox1.isSelected()){ // if not selected,that why is "!"
            System.out.println("Checkbox is NOT selected. Verification PASSED");
        }else{
            System.out.println("Checkbox is selected. Verification FAILED !!!");
        }


        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        if(checkbox2.isSelected()){
            System.out.println("Checkbox is selected. Verification PASSED");
        }else{
            System.out.println("Checkbox is NOT selected. Verification FAILED !!!");
        }


        // 4.Click	checkbox	#1	to	select	it.
        Thread.sleep(1000); // we don't need but just in case
        checkbox1.click();

        // 5.Click	checkbox	#2	to	deselect	it.
        Thread.sleep(1000);
        checkbox2.click();

        // 6.Confirm	checkbox	#1	is	SELECTED.
       if(checkbox1.isSelected()){
           System.out.println("Checkbox 1 is SELECTED ");
       }else{
           System.out.println("Checkbox 1 is NOT SELECTED ");
       }

        // 7.Confirm	checkbox	#2	is	NOT	SELECTED
        if(checkbox2.isSelected()){
            System.out.println("Checkbox 2 is SELECTED ");
        }else{
            System.out.println("Checkbox 2 is NOT SELECTED ");
        }

    }
}
