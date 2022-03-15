package com.mthree.foundations.flowcontroll.whiles;

import java.util.Scanner;

public class BewareTheKraken {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Where do you want to stop: ");
        int stoppingPoint = input.nextInt();
        int depthDivedInFt = 0;

        while(depthDivedInFt < 36200){
            System.out.println("So far, we've swum " + depthDivedInFt + " feet");

            if(depthDivedInFt >= 20000){
                System.out.println("Uhhh, I think I see a Kraken, guys ....");
                System.out.println("TIME TO GO!");
                break;
            }

            if(depthDivedInFt >= stoppingPoint){
                System.out.println("Okay we reached your stopping point");
                break;
            }


            depthDivedInFt += 1000;
        }
        System.out.println("");
        System.out.println("We ended up swimming " + depthDivedInFt + " feet down.");
        System.out.println("I bet we can do better next time!");
    }
}
