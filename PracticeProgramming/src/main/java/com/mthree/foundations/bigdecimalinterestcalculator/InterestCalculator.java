package com.mthree.foundations.bigdecimalinterestcalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class InterestCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How much do you want to invest? ");
        BigDecimal initialInvestment = input.nextBigDecimal();
        System.out.println("How many years are investing? ");
        BigDecimal yearsInvesting = input.nextBigDecimal();
        System.out.print("What is the annual interest rate % growth? ");
        BigDecimal yearlyInterestRate = input.nextBigDecimal();
        BigDecimal quarterlyInterestRate = yearlyInterestRate.divide(new BigDecimal("4.0"));
        BigDecimal currentBalance = initialInvestment;
        System.out.println("Calculating...");

        //set scale for all




        for(int i = 0; i < yearsInvesting.intValue(); i++){
            initialInvestment = currentBalance;
            System.out.println("Year " + i + ":");
            System.out.println("Began with $ " + initialInvestment.setScale(2, RoundingMode.DOWN));

            for(int j = 0; j < 4; j++){
                //below is equal to:   currentBalance *= (1 + (quarterlyInterestRate / 100));

                BigDecimal rhs =  (quarterlyInterestRate.divide(new BigDecimal("100")));
                rhs = rhs.add(new BigDecimal("1"));
                currentBalance = currentBalance.multiply(rhs);
            }

            BigDecimal ammountEarned = currentBalance.subtract(initialInvestment);
            System.out.println("You Earned: " + ammountEarned.setScale(2, RoundingMode.DOWN));
            System.out.println("Ended with: " + currentBalance.setScale(2, RoundingMode.DOWN));
            System.out.println();
        }

    }
}

