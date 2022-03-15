package com.mthree.foundations.enums.mathoperators;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value one: ");
        int val1 = scanner.nextInt();
        System.out.print("Enter value two: ");
        int val2 = scanner.nextInt();

        System.out.println(val1 + " + " + val2 + " = " + IntMath.calculate(MathOperator.PLUS, val1, val2));
        System.out.println(val1 + " - " + val2 + " = " + IntMath.calculate(MathOperator.MINUS, val1, val2));
        System.out.println(val1 + " * " + val2 + " = " + IntMath.calculate(MathOperator.MULTIPLY, val1, val2));
        System.out.println(val1 + " / " + val2 + " = " + IntMath.calculate(MathOperator.DIVIDE, val1, val2));



    }
}
