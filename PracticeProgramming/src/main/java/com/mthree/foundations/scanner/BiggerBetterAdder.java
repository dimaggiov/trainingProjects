package com.mthree.foundations.scanner;

import java.util.Scanner;

public class BiggerBetterAdder {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Input value 1: ");
        int val1 = input.nextInt();
        System.out.println("Input value 2: ");
        int val2 = input.nextInt();
        System.out.println("Input value 3: ");
        int val3 = input.nextInt();
        int sum = val1 + val2 + val3;

        System.out.println(val1 + " + " + val2 + " + " + val3 + " = " + sum);
    }
}
