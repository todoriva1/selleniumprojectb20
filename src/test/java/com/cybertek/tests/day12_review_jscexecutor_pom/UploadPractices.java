package com.cybertek.tests.day12_review_jscexecutor_pom;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UploadPractices {

    @Test
    public void uploading_file_test(){
    //getting the page
        Driver.getDriver().get("http://practice.cybertekschool.com/upload");
        Driver.getDriver().manage().window().maximize();

        //get the path of the file you want to upload
        //MAC: right click on the file you to upload
        // click and hold "option" button and select "copy as path name"
        String path = "/Users/ivantodorovski/Documents/.Advance wine and food knowledge.pdf.icloud";

        //locate the upload web element
        WebElement uploadInput = Driver.getDriver().findElement(By.id("file-upload"));

        //send the path of the file to uploadInput webElement
        uploadInput.sendKeys(path);

        //locate the UPLOAD button
        WebElement uploadButton = Driver.getDriver().findElement(By.id("file-submit"));

        //click to upload button
        BrowserUtils.wait(2);
        uploadButton.click();

    }

}
