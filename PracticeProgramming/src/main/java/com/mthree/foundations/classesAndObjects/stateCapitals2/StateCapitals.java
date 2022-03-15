package com.mthree.foundations.classesAndObjects.stateCapitals2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class StateCapitals {
    public static void main(String[] args) throws Exception {
        Map<String, String> capitals = new HashMap<>();
        Scanner fileInput = new Scanner(new BufferedReader(new FileReader("src/main/java/com/mthree/foundations/classesAndObjects/StateCapitals2/input")));

        while(fileInput.hasNextLine()){
            String wholeLine = fileInput.nextLine();
            String[] splitString = wholeLine.split("::");
            capitals.put(splitString[0], splitString[1]);
        }

        System.out.println("There are " + capitals.size() + " pairs in this map");

        System.out.println("Here are all the states:");
        for (String s: capitals.keySet()) {
            System.out.print(s + ", ");
        }
        System.out.println();

        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int r = random.nextInt(capitals.size());
        String state = (String) capitals.keySet().toArray()[r];
        System.out.println("What is the capital of " + state + "?");
        String answer = input.nextLine();

        if(answer.equalsIgnoreCase(capitals.get(state)))
            System.out.println("Correct!");
        else
            System.out.println("Wrong, the capital of " + state + " is " + capitals.get(state));


    }
}
