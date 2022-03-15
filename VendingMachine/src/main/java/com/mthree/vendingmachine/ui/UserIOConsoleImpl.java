package com.mthree.vendingmachine.ui;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserIOConsoleImpl implements UserIO{

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public String readString(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    @Override
    public int readInt(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextInt();
    }

    @Override
    public int readInt(String prompt, int min, int max) {

        Scanner s = new Scanner(System.in);
        int input = 0;
        do{
            System.out.println(prompt);
            input = s.nextInt();
        }while(input < min || input > max);

        return input;
    }

    @Override
    public double readDouble(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextDouble();
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        Scanner s = new Scanner(System.in);
        double input = 0;
        do{
            System.out.println(prompt);
            input = s.nextDouble();
        }while(input < min || input > max);

        return input;
    }

    @Override
    public float readFloat(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextFloat();
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        Scanner s = new Scanner(System.in);
        float input = 0;
        do{
            System.out.println(prompt);
            input = s.nextFloat();
        }while(input < min || input > max);

        return input;
    }

    @Override
    public long readLong(String prompt) {
        System.out.println(prompt);
        Scanner s = new Scanner(System.in);
        return s.nextLong();
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        Scanner s = new Scanner(System.in);
        long input = 0;
        do{
            System.out.println(prompt);
            input = s.nextLong();
        }while(input < min || input > max);

        return input;
    }
}
