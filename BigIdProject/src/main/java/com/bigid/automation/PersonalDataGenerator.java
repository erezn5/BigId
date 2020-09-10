package com.bigid.automation;

import java.util.*;

public class PersonalDataGenerator {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please enter number of personal data to generate");
        int size = s.nextInt();

        for(int i = 0; i < size; i++) {
            Person.personDetailsGenerator();
        }

    }

}
