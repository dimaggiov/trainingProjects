package com.mthree.factorizer;

import java.util.ArrayList;
import java.util.Scanner;

public class Factorizer {

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.print("What number do you want to factor? ");
        int userValue = input.nextInt();

        ArrayList<Integer> factors = new ArrayList<Integer>();
        System.out.println("The factors of " + userValue + " are:");

        for(int i = 1; i <= userValue; i++){
            if(userValue % i == 0){
                factors.add(i);
                System.out.print(i + " ");
            }
        }
        factors.remove(factors.size()-1);
        System.out.println();

        System.out.println(userValue + " has " + (factors.size() + 1) + " factors" );

        int sum = 0;
        for (int i:factors) {
            sum+=i;
        }
        if(sum == userValue)
            System.out.println(userValue + " is a perfect number");
        else
            System.out.println(userValue + " is not a perfect number");

        if(factors.size() == 1)
            System.out.println(userValue + " is a prime number");
        else
            System.out.println(userValue + " is not a prime number");




    }




}
