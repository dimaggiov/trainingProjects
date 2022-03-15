package com.mthree.foundations.scanner;

import java.util.Scanner;

public class MiniMadLibs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("I need a noun: ");
        String noun1 = input.nextLine();
        System.out.println("Now an adjective: ");
        String adjective1 = input.nextLine();
        System.out.println("Another noun: ");
        String noun2 = input.nextLine();
        System.out.println("And a number: ");
        String number = input.nextLine();
        System.out.println("Another adjective: ");
        String adjective2 = input.nextLine();
        System.out.println("A plural noun: ");
        String pluralNoun1 = input.nextLine();
        System.out.println("Another one: ");
        String pluralNoun2 = input.nextLine();
        System.out.println("One more: ");
        String pluralNoun3 = input.nextLine();
        System.out.println("A verb (infinitive form): ");
        String infVerb = input.nextLine();
        System.out.println("Same verb (past participle): ");
        String ppVerb = input.nextLine();

        System.out.println("*** NOW LETS GET MAD (libs) ***");
        System.out.println(noun1 + ": the " + adjective1 + " frontier. These are the voyages of the starship " + noun2 +
                ". Its " + number + "-year mission: to explore strange " + adjective2 + " " + pluralNoun1 +
                " to seek out " + adjective2 + " " + pluralNoun2 + " and " + adjective2 + " " + pluralNoun3 + " to boldly " +
                infVerb + " where no one has " + ppVerb + " before.");

    }
}
