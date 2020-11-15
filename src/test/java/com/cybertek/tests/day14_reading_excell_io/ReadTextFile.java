package com.cybertek.tests.day14_reading_excell_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTextFile {

    public static void main(String[] args) throws FileNotFoundException {
        //path to the file we want to read
        String path = "shopping_list.txt";

        File file = new File(path);
        System.out.println(file.exists()); // check if file exists

        //System.in -for keyboard inout
        //file object - for reading file
        Scanner scanner = new Scanner(file);

        System.out.println(scanner.nextLine());
        System.out.println(scanner.nextLine());

        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }




    }

}
