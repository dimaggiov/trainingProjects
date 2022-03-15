package com.mthree.foundations.classesAndObjects.refactoredExercises.rockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public void play() {

        Scanner input = new Scanner(System.in);
        String playAgain = "yes";

        while(playAgain.equalsIgnoreCase("yes")) {

            System.out.print("How many rounds do you want to play (1-10): ");
            int rounds = Integer.parseInt(input.nextLine());
            if (rounds > 10 || rounds < 1) {
                System.out.println(rounds + " is not a valid input");
                return;
            }


            Random random = new Random();
            int tie = 0, win = 0, loss = 0;

            for (int i = 0; i < rounds; i++) {
                System.out.print("Rock(1), Paper(2), or Scissors(3): ");
                int userChoice = Integer.parseInt(input.nextLine());
                int cpuChoice = random.nextInt(3) + 1;

                switch (userChoice){
                    case 1:
                        switch (cpuChoice){
                            case 1:
                                System.out.println("You both chose rock, it's a tie!");
                                tie++;
                                break;
                            case 2:
                                System.out.println("You chose rock and the computer chose paper. You lose!");
                                loss++;
                                break;
                            case 3:
                                System.out.println("You chose rock and the computer chose scissors. You win!");
                                win++;
                                break;
                        }
                        break;

                    case 2:
                        switch (cpuChoice){
                            case 1:
                                System.out.println("You chose paper and the computer chose rock. You win!");
                                win++;
                                break;
                            case 2:
                                System.out.println("You both chose paper, it's a tie!");
                                tie++;
                                break;
                            case 3:
                                System.out.println("You chose paper and the computer chose scissors. You lose!");
                                loss++;
                                break;
                        }
                        break;

                    case 3:
                        switch (cpuChoice){
                            case 1:
                                System.out.println("You chose scissors and the computer chose rock. You lose!");
                                loss++;
                                break;
                            case 2:
                                System.out.println("You chose scissors and the computer chose paper. You win!");
                                win++;
                                break;
                            case 3:
                                System.out.println("You both chose scissors, it's a tie!");
                                tie++;
                                break;
                        }
                        break;
                } //end user switch

            }//end game loop


            System.out.println("You won " + win + " rounds, lost " + loss + " rounds and tied " + tie + " rounds.");
            if(win > loss)
                System.out.println("You are the overall winner!");
            else if(win < loss)
                System.out.println("The computer is the overall winner!");
            else
                System.out.println("It's a tie!");


            System.out.print("Would you like to play again? ");
            playAgain = input.nextLine();

        } //end play again loop

        System.out.println("Thanks for playing!");

    }
}

