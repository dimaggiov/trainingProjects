package com.mthree.foundations.scanner;

import java.util.Scanner;

public class HealthyHearts {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your age? ");
        int age = input.nextInt();
        int maximum = 220 - age;
        System.out.println("Your maximum heart rate should be " + maximum + " beats per minute.");
        System.out.println("Your target HR zone is " + ((int)(.5 * maximum)) + " - " + ((int)(.85 * maximum)) + " beats per minute");
    }
}
