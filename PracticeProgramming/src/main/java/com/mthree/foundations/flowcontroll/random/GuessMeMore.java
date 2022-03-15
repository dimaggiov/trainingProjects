package com.mthree.foundations.flowcontroll.random;

import java.util.Random;
import java.util.Scanner;

public class GuessMeMore {

    public static void main(String[] args) {

        Random random = new Random();
        int value = random.nextInt(200) - 100;

        Scanner input = new Scanner(System.in);
        System.out.println("Guess the number: ");
        int guess = input.nextInt();

        if(guess < value)
        {
            System.out.println("Too low! Try again");
            guess = input.nextInt();
            if(guess < value)
            {
                System.out.println("Too low!");
            } else if(guess > value){
                System.out.println("Too high!");
            }
            else{
                System.out.println("Wow you got it!");
            }
        } else if(guess > value){
            System.out.println("Too high! Try Again");
            guess = input.nextInt();
            if(guess < value)
            {
                System.out.println("Too low!");
            } else if(guess > value){
                System.out.println("Too high!");
            }
            else{
                System.out.println("Wow you got it!");
            }
        }
        else{
            System.out.println("Wow first try!");
        }











    }
}
