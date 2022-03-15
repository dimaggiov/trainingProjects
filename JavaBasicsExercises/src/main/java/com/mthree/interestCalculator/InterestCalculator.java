package com.mthree.interestCalculator;

import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How much do you want to invest? ");
        double initialInvestment = input.nextDouble();
        System.out.println("How many years are investing? ");
        int yearsInvesting = input.nextInt();
        System.out.print("What is the annual interest rate % growth? ");
        double yearlyInterestRate = input.nextDouble();


        double quarterlyInterestRate = yearlyInterestRate / 4.0;
        double currentBalance = initialInvestment;
        System.out.println("Calculating...");

        for(int i = 0; i < yearsInvesting; i++){
            initialInvestment = currentBalance;
            System.out.println("Year " + i + ":");
            System.out.println("Began with $ " + initialInvestment);

            currentBalance *= (1 + (quarterlyInterestRate / 100));
            currentBalance *= (1 + (quarterlyInterestRate / 100));
            currentBalance *= (1 + (quarterlyInterestRate / 100));
            currentBalance *= (1 + (quarterlyInterestRate / 100));

            System.out.println("You Earned: " + (currentBalance - initialInvestment));
            System.out.println("Ended with: " + currentBalance);
            System.out.println();
        }

    }
}
