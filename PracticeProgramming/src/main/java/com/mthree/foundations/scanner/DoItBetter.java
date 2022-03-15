package com.mthree.foundations.scanner;

import java.util.Scanner;

public class DoItBetter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many miles can you run?");
        int miles = input.nextInt();
        System.out.println("Yeah well I can run " + (miles * 2 + 1) + " miles.");

        System.out.println("How many hot dogs can you eat?");
        int hotdogs = input.nextInt();
        System.out.println("Yeah well I can eat " + (hotdogs * 2 + 1) + " hot dogs.");

        System.out.println("How many languages do you know?");
        int languages = input.nextInt();
        System.out.println("Yeah well I know " + (languages * 2 + 1) + " languages.");

    }
}
