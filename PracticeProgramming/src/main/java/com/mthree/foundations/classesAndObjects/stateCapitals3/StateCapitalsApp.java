package com.mthree.foundations.classesAndObjects.stateCapitals3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StateCapitalsApp {

    public static void main(String[] args) throws Exception{
        Map<String, Capital> capitals = new HashMap<>();
        Scanner fileInput = new Scanner(new BufferedReader(new FileReader("src/main/java/com/mthree/foundations/classesAndObjects/StateCapitals3/input")));

        while(fileInput.hasNextLine()){
            String wholeLine = fileInput.nextLine();
            String[] splitString = wholeLine.split("::");
            String state = splitString[0];
            Capital capital = new Capital(splitString[1], Integer.parseInt(splitString[2]) ,Double.parseDouble(splitString[3]));
            capitals.put(state, capital);
        }

        System.out.println("There are " + capitals.size() + " pairs in this map");

        for (String s : capitals.keySet()) {
            Capital capital = capitals.get(s);
            System.out.println(s + " - " + capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSqMiles() + " sq mi");

        }

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the lower limit for capital population: ");
        int population = userInput.nextInt();
        System.out.println("Listing capitals with populations greater than " + population );
        for (String s : capitals.keySet()) {
            Capital capital = capitals.get(s);
            if(capital.getPopulation() > population)
                System.out.println(s + " - " + capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSqMiles() + " sq mi");

        }

        System.out.println("Enter the upper limit for capital sq mileage: ");
        double size = userInput.nextDouble();
        System.out.println("Listing capitals with areas less than " + size);
        for (String s : capitals.keySet()) {
            Capital capital = capitals.get(s);
            if(capital.getSqMiles() < size)
                System.out.println(s + " - " + capital.getName() + " | Pop: " + capital.getPopulation() + " | Area: " + capital.getSqMiles() + " sq mi");
        }



    }
}
