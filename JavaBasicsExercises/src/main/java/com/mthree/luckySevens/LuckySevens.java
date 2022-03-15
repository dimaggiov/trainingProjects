package com.mthree.luckySevens;

import java.util.Random;
import java.util.Scanner;

public class LuckySevens {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How much are you betting? ");
        int money = input.nextInt();

        int maxMoney = money;
        int maxRoll = 0;
        int roll = 0;
        while(money != 0){
            roll++;
            int dieOne = random.nextInt(6-1) + 1;
            int dieTwo = random.nextInt(6-1) + 1;

            if(dieOne + dieTwo == 7)
                money += 4;
            else
                money--;

            if(money > maxMoney) {
                maxMoney = money;
                maxRoll = roll;
            }
        }

        System.out.println("You broke after: " + roll + " rolls");
        System.out.println("You should have stopped after: " + maxRoll +" rolls, you had $" + maxMoney);

    }

}
