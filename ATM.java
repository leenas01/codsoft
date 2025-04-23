package com.atmbankroject;

import java.util.Scanner;

public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;

        System.out.println(" Welcome to the  ATM!");

        do {
            System.out.println("\nPlease select an option:");
            System.out.println("1️  Check Balance");
            System.out.println("2️  Deposit");
            System.out.println("3️  Withdraw");
            System.out.println("4️  Exit");
            System.out.print("Enter option (1-4): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Enter a number (1-4): ");
                scanner.next();
            }

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid option. Please select between 1 and 4.");
            }

        } while (option != 4);

        scanner.close();
    }

    public void checkBalance() {
        System.out.printf(" Current Balance: ₹%.2f\n", account.getBalance());
    }

    public void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ₹");
        double amount = scanner.nextDouble();

        if (account.deposit(amount)) {
            System.out.println(" Deposit successful!");
            checkBalance();
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    public void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ₹");
        double amount = scanner.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println(" Withdrawal successful!");
            checkBalance();
        } else {
            System.out.println(" Withdrawal failed! Check your balance or amount.");
        }
    }

    // Main method
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.00);
        ATM atmMachine = new ATM(userAccount);
        atmMachine.showMenu();
    }
}

