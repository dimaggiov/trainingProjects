package com.mthree.foundations.flowcontroll.fors;

import java.util.Scanner;

public class ForTimes {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("What table should i display: ");
        int number = input.nextInt();

        for(int i = 1; i < 16; i++)
            System.out.println(i + " * " + number + " is: " + (i*number) );
    }
}
