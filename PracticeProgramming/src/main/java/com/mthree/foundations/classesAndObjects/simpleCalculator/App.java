package com.mthree.foundations.classesAndObjects.simpleCalculator;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userChoice = 0;

        while(userChoice != 5) {
            System.out.println("Would you like to add (1) subtract (2) multiply (3) or divide (4) or exit (5)");
            userChoice = input.nextInt();
            SimpleCalculator calculator = new SimpleCalculator();

            if(userChoice == 5) {
                System.out.println("Thanks for using the calculator, goodbye");
                return;
            }

            System.out.print("What is value 1: ");
            calculator.setValue1(input.nextDouble());
            System.out.print("What is value 2: ");
            calculator.setValue2(input.nextDouble());

            switch (userChoice){
                case 1:
                    System.out.println(calculator.getValue1() + " + "  + calculator.getValue2() + " = " + calculator.add());
                    break;
                case 2:
                    System.out.println(calculator.getValue1() + " - "  + calculator.getValue2() + " = " + calculator.subtract());
                    break;
                case 3:
                    System.out.println(calculator.getValue1() + " * "  + calculator.getValue2() + " = " + calculator.multiply());
                    break;
                case 4:
                    System.out.println(calculator.getValue1() + " / "  + calculator.getValue2() + " = " + calculator.divide());
                    break;
            }




        }
    }
}
