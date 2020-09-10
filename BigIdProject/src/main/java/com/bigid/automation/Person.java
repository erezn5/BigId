package com.bigid.automation;

import com.github.javafaker.Faker;

public class Person {

    static void personDetailsGenerator() {
        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = firstCharToLowerCase(firstName + "@company.com");
        String city = faker.address().city();
        String country = faker.address().country();
        String id =  faker.idNumber().valid().replace("-", "");

        StringBuilder sb = new StringBuilder();
        sb.append(email).append(",").append(firstName).append(",").append(lastName).append(",")
                .append(city).append(",").append(country).append(",").append(id);
        System.out.println(sb);
    }

    private static String firstCharToLowerCase(String str) {
        char[] chArr = str.toCharArray();
        chArr[0] = Character.toLowerCase(chArr[0]);
        return new String(chArr);
    }
}
