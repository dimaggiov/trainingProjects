package com.mthree.foundations.flowcontroll.ifs;

import java.util.Scanner;

public class MiniZork {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("You feel something slimey");
                System.out.println("Try and grab it or run away?");
                action = userInput.nextLine();
                if (action.equals("grab it")) {
                    System.out.println("Turns out the slimey thing grabbed you back.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you alive. Possibly a wise choice.");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You enter the house");
            System.out.println("Enter the kitchen or bedroom?");
            action = userInput.nextLine();
            if (action.equals("kitchen")) {
                System.out.println("There is a fresh baked pie on the windowsill");
                System.out.println("Eat it?");
                action = userInput.nextLine();
                if (action.equals("yes")) {
                    System.out.println("An angry bear appears behind you, turns out it was his pie");
                    System.out.println("You've been eaten by a bear.");
                } else if (action.equals("no")) {
                    System.out.println("Regretfully, you leave the pie where it is and go to take a nap");
                    System.out.println("Hungry...");
                }
                action = userInput.nextLine();
            } else if (action.equals("bedroom")) {
                System.out.println("You enter the bedroom");
                System.out.println("There is something sleeping in the bed");
                System.out.println("Wake it up?");
                action = userInput.nextLine();
                if (action.equals("yes")) {
                    System.out.println("Turns out you poked a sleeping bear");
                    System.out.println("You've been eaten by a bear.");
                } else if (action.equals("no")) {
                    System.out.println("You let it keep sleeping and go home");
                }

            }

        }
    }
}
