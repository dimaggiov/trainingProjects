package com.mthree.foundations.enums.daystofriday;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What day of the week is it? ");
        Day choice = Day.valueOf(scanner.nextLine().toUpperCase());

        switch (choice) {
            case MONDAY:
                System.out.println("There are 4 days to friday");
                break;
            case TUESDAY:
                System.out.println("There are 3 days to friday");
                break;
            case WEDNESDAY:
                System.out.println("There are 2 days to friday");
                break;
            case THURSDAY:
                System.out.println("There is 1 day to friday");
                break;
            case FRIDAY:
                System.out.println("Its Friday!");
                break;
            case SATURDAY:
                System.out.println("There are 5 days to friday");
                break;
            case SUNDAY:
                System.out.println("There are 6 days to friday");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
