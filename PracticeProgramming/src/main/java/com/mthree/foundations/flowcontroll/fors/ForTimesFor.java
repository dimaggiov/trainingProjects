package com.mthree.foundations.flowcontroll.fors;

import java.util.Scanner;

public class ForTimesFor {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("What table should i display: ");
        int number = input.nextInt();

        for(int i = 1; i < 16; i++) {
            System.out.print("What is " + i + " * " + number + "? ");
            int ans = input.nextInt();
            if(ans == i * number){
                System.out.println("Correct!");
            }
            else{
                System.out.println("Wrong the answer is: " + (i * number));
            }
        }

    }
}
