package com.gradecalculator;

import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean runAgain = true;

        System.out.println(" Welcome to the Grade Calculator App!");

        while (runAgain) {
            System.out.print("\n Enter the number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            // Input marks
            for (int i = 0; i < numSubjects; i++) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                marks[i] = scanner.nextInt();

                while (marks[i] < 0 || marks[i] > 100) {
                    System.out.println(" Invalid input! Marks must be between 0 and 100.");
                    System.out.print("Re-enter marks for subject " + (i + 1) + ": ");
                    marks[i] = scanner.nextInt();
                }

                totalMarks += marks[i];
            }

            // Calculate average
            double average = (double) totalMarks / numSubjects;

            // Grade logic
            String grade;
            if (average >= 90) {
                grade = "A+";
            } else if (average >= 80) {
                grade = "A";
            } else if (average >= 70) {
                grade = "B";
            } else if (average >= 60) {
                grade = "C";
            } else if (average >= 50) {
                grade = "D";
            } else {
                grade = "F";
            }

            // Display result
            System.out.println("\n --- Report Card ---");
            System.out.println("Total Marks: " + totalMarks + " out of " + (numSubjects * 100));
            System.out.printf("Average Percentage: %.2f%%\n", average);
            System.out.println("Grade: " + grade);

            // Ask to run again or exit
            System.out.print("\n Do you want to calculate another grade? (yes/no): ");
            scanner.nextLine(); // clear buffer
            String response = scanner.nextLine().trim().toLowerCase();

            if (!response.equals("yes")) {
                runAgain = false;
                System.out.println("Exiting Grade Calculator. Thank you!");
            }
        }

        scanner.close();
    }
}
