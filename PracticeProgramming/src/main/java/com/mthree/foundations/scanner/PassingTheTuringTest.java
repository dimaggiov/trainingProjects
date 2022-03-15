package com.mthree.foundations.scanner;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PassingTheTuringTest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello there!");
        System.out.println("What's your name? ");
        String name = input.nextLine();
        System.out.println("Hi, " + name + "! I'm Turing.");
        System.out.println("What's your favorite color? ");
        String color = input.nextLine();
        System.out.println("Huh, " + color + ". Mine's Electric Lime.");
        System.out.println("What's YOUR favorite fruit, " + name + "?");
        String fruit = input.nextLine();
        System.out.println("Really? " + fruit + "? That's Wild!");
        System.out.println("Speaking of favorites, what's your favorite number?");
        int number = input.nextInt();
        System.out.println(number + " is a cool number. Mine's 5.");
        System.out.println("Did you know " + number + " * 5 is " + (number * 5) + "? That's a cool number too!");
        System.out.println("Well, thanks for talking with me, " + name + "!" );

    }



}
