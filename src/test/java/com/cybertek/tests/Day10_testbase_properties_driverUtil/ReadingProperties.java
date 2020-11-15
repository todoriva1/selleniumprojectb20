package com.cybertek.tests.Day10_testbase_properties_driverUtil;

import com.cybertek.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {

    @Test
    public void reading_from_properties_file() throws IOException {

        //Properties: use Properties class object
        //We create below properties object to be able to read configuration.properties file
        //import from java.util
        Properties properties = new Properties();

        //FileInputStream: opens the file
        String path = "configuration.properties";

        //we need to pass the path of the file we want to open in JVM
        FileInputStream file = new FileInputStream(path); // throws IOException is added next to class name


        //We will load the file
        properties.load(file);


        //We read from the file
        //properties.getProperty("browser").soutv + enter;  --> look below
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser")); // chrome
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username")); // johndoe --> pogledati configuration.properties file


        //Close the file
        file.close();



    }



    //new test below


    @Test
    public void using_properties_utility_method(){
        //This will read the given "key's" value and return it as a String
        // ConfigurationReader.getProperty("broswer").soutv + enter below
        System.out.println("ConfigurationReader.getProperty(\"broswer\") = " + ConfigurationReader.getProperty("browser"));
        System.out.println("ConfigurationReader.getProperty(\"smartbearUrl\") = " + ConfigurationReader.getProperty("smartbearUrl"));
    }


}
