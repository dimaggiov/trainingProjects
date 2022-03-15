package com.mthree.foundations.classesAndObjects.stateCapitals1;

import java.util.HashMap;
import java.util.Map;

public class StateCapitals {

    public static void main(String[] args) {
        Map<String,String> capitals = new HashMap<>();
        capitals.put("Alabama", "Montgomery");
        capitals.put("Alaska", "Juneau");
        capitals.put("Arizona", "Phoenix");
        capitals.put("Arkansas", "Little Rock");
        capitals.put("California", "Sacramento");
        capitals.put("Colorado", "Denver");
        capitals.put("Connecticut", "Hartford");
        capitals.put("Delaware", "Dover");


        System.out.println("States:");
        for (String s: capitals.keySet()) {
            System.out.println(s);
        }

        System.out.println("Capitals:");
        for (String s : capitals.values()) {
            System.out.println(s);
        }

        System.out.println("State/capital pairs");
        for (String s: capitals.keySet()) {
            System.out.println(s + " - " + capitals.get(s));
        }
    }


}
