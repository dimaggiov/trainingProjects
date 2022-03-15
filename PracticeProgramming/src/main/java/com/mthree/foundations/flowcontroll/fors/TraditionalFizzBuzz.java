package com.mthree.foundations.flowcontroll.fors;

import java.util.Scanner;

public class TraditionalFizzBuzz {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("How many fizzbuzzs: ");
        int goal = input.nextInt();

        int count = 0;
        for(int i = 1; count < goal; i++){
            if(i % 3 == 0 && i % 5 == 0) {
                System.out.println("fizz buzz");
                count++;
            }
            else if(i % 5 == 0) {
                System.out.println("buzz");
                count++;
            }
            else if(i % 3 == 0 ) {
                System.out.println("fizz");
                count++;
            }
            else
                System.out.println(i);



        }


    }
}
