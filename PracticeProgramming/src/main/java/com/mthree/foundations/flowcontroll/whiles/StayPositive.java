package com.mthree.foundations.flowcontroll.whiles;

import java.util.Scanner;

public class StayPositive {

    public static void main(String[] args) {

        Scanner input  = new Scanner(System.in);
        System.out.println("Enter a number to count down from: ");
        int i = input.nextInt();
        while(i >= 0) {
            System.out.println(i);
            i--;
        }

        System.out.println("Blast off");

    }
}
