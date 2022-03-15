package com.mthree.foundations.scanner;

import java.util.Scanner;

public class AllTheTrivia {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        System.out.println("What does “www” stand for in a website browser?");
        String answer1 = input.nextLine();
        System.out.println("What countries made up the original Axis powers in World War II?");
        String answer2 = input.nextLine();
        System.out.println("What is \"cynophobia\"");
        String answer3 = input.nextLine();
        System.out.println("Which countries still have Shilling as currency?");
        String answer4 = input.nextLine();

        System.out.println("Oh so WWW means " + answer3 + ".");
        System.out.println("And the Axis was " + answer4 + ".");
        System.out.println("I didnt know cynophobia meant " + answer1 + ".");
        System.out.println("Wow " + answer2 + " still use the Schilling that's really cool.");

    }
}
