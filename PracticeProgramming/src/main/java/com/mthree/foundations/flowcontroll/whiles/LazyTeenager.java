package com.mthree.foundations.flowcontroll.whiles;

import java.util.Random;

public class LazyTeenager {

    public static void main(String[] args) {

        Random random = new Random();
        int willClean;

        int timesTold = 0;
        while(timesTold <= 7){
            timesTold++;
            System.out.println("Clean your room (" + timesTold + "x)");
            if(timesTold == 7){
                System.out.println("IM TAKING YOUR XBOX AWAY");
                break;
            }
            willClean = random.nextInt(10);
            if(willClean > 9 - timesTold){
                System.out.println("FINE ILL CLEAN MY ROOM");
                break;
            }

        }
    }
}
