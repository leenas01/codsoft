package com.codesoft;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 7;
        int roundsWon = 0;
        int totalRounds = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int numberToGuess = random.nextInt(100) + 1; // 1 to 100
            int attemptsLeft = maxAttempts;
            boolean guessedCorrectly = false;

            System.out.println("\n I'm thinking of a number between 1 and 100. Can you guess it?");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attemptsLeft > 0) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println(" Correct! You guessed the number in " + (maxAttempts - attemptsLeft + 1) + " attempts.");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println(" Too low!");
                } else {
                    System.out.println(" Too high!");
                }

                attemptsLeft--;
                System.out.println("Attempts left: " + attemptsLeft);
            }

            if (!guessedCorrectly) {
                System.out.println(" You've used all your attempts! The number was: " + numberToGuess);
            }

            totalRounds++;
            System.out.print("\n Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume newline
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("\n Game Over!");
        System.out.println(" Total Rounds Played: " + totalRounds);
        System.out.println(" Rounds Won: " + roundsWon);
        scanner.close();
    }
}

