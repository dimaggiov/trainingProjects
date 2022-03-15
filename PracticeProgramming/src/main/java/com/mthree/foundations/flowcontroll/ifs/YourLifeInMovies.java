package com.mthree.foundations.flowcontroll.ifs;

import java.util.Scanner;

public class YourLifeInMovies {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("What year were you born: ");
        int age = input.nextInt();

        if(age<2005)
            System.out.println("Pixar's 'Up' came out over a decade ago");
        if(age<1995)
            System.out.println("The first Harry Potter came out over 15 years ago");
        if(age<1985)
            System.out.println("Space Jam came out not last decade, but the one before THAT");
        if(age<1975)
            System.out.println("The original Jurassic Park release is closer to the first lunar landing than it is to today.");
        if(age<1965)
            System.out.println("The MASH TV series has been around for almost half a century");
    }
}
