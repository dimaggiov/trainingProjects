package com.mthree.foundations.flowcontroll.methods;

import java.util.Random;

public class BarelyControlledChaos {

    public static void main(String[] args) {

        String color = color(); // call color method here
        String animal = animal(); // call animal method again here
        String colorAgain = color(); // call color method again here
        int weight = randomNumber(5, 200); // call number method,
        // with a range between 5 - 200
        int distance = randomNumber(10, 20);; // call number method,
        // with a range between 10 - 20
        int number = randomNumber(10000, 20000);; // call number method,
        // with a range between 10000 - 20000
        int time = randomNumber(2, 6);; // call number method,
        // with a range between 2 - 6

        System.out.println("Once, when I was very small...");

        System.out.println("I was chased by a " + color + ", "
                + weight + "lb " + " miniature " + animal
                + " for over " + distance + " miles!!");

        System.out.println("I had to hide in a field of over "
                + number + " " + colorAgain + " poppies for nearly "
                + time + " hours until it left me alone!");

        System.out.println("\nIt was QUITE the experience, "
                + "let me tell you!");
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static String animal() {
        Random random = new Random();
        int animal = random.nextInt(5);

        switch(animal){
            case 0:
                return "horse";
            case 1:
                return "dog";
            case 2:
                return "cat";
            case 3:
                return "cow";
            case 4:
                return "emu";

        }
        return "";
    }

    public static String color() {
        Random random = new Random();
        int color = random.nextInt(5) ;

        switch(color){
            case 0:
                return "blue";
            case 1:
                return "red";
            case 2:
                return "green";
            case 3:
                return "pink";
            case 4:
                return "black";

        }
        return "";
    }

}
