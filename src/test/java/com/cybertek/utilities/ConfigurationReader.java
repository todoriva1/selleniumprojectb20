package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    //#1 - We created the properties object
    private static Properties properties = new Properties(); // private to limited access

    static {
        try {
            //#2 - We get the path and pass it into FileInputStream, to open the file
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3 - We load the opened file into properties object
            properties.load(file);

            //#5 - close the file
            file.close();

        } catch (IOException e) {
            System.out.println("Properties file not found ");// ovo automatski try&catch kad se misom pokaze crvena linija
        }

    }

    //#4 - We read from file: we will creating utility method for reading.
    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }
    //#5 - close the file

}
