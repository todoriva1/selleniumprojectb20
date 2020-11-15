package com.cybertek.tests.day6_dropdown_review;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void faker_test(){

        //we need to create object from the faker class to be able to use method
        Faker faker =new Faker();

        String firstName = faker.name().firstName();
        System.out.println("firstName = " + firstName);

        String lastName = faker.name().lastName();
        System.out.println("lastName = " + lastName);

        String fullName = faker.name().fullName();
        System.out.println("fullName = " + fullName);

        String address = faker.address().fullAddress();
        System.out.println("address = " + address);

        String gameOfThrones = faker.gameOfThrones().house();
        System.out.println("gameOfThrones = " + gameOfThrones);

        String quote = faker.gameOfThrones().quote();
        System.out.println("quote = " + quote);

        String ChuckNorris = faker.chuckNorris().fact();
        System.out.println("ChuckNorris = " + ChuckNorris);






    }
}
