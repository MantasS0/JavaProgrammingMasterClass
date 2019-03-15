package com.company.AutoBoxingAndUnboxingChallenge;


import java.util.Scanner;

public class AutoBoxingAndUnboxingChallengeMain {

    // You job is to create a simple banking application.
    // There should be a Bank class
    // It should have an arraylist of Branches
    // Each Branch should have an arraylist of Customers
    // The Customer class should have an arraylist of Doubles (transactions)
    // Customer:
    // Name, and the ArrayList of doubles.
    // Branch:
    // Need to be able to add a new customer and initial transaction amount.
    // Also needs to add additional transactions for that customer/branch
    // Bank:
    // Add a new branch
    // Add a customer to that branch with initial transaction
    // Add a transaction for an existing customer for that branch
    // Show a list of customers for a particular branch and optionally a list
    // of their transactions
    // Demonstration autoboxing and unboxing in your code
    // Hint: Transactions
    // Add data validation.
    // e.g. check if exists, or does not exist, etc.
    // Think about where you are adding the code to perform certain actions

    private static Bank bank = new Bank();
    private static boolean flag = true;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        doBanking();
    }

    private static void doBanking() {
        printInstructions();
        while (flag) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 1:
                    printInstructions();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    addTransactionToCustomer();
                    break;
                case 5:
                    printCustomerList();
                    break;
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("Wrong input action chosen. Please try again.");
            }
        }
    }

    private static void printInstructions() {
        System.out.println("Instructions:");
        System.out.println("Type " + '"' + 1 + '"' + " to print the instructions.");
        System.out.println("Type " + '"' + 2 + '"' + " to add a new branch to bank.");
        System.out.println("Type " + '"' + 3 + '"' + " to add a customer to specific branch.");
        System.out.println("Type " + '"' + 4 + '"' + " to add a transaction to a specific customer.");
        System.out.println("Type " + '"' + 5 + '"' + " to print the customer list of a specific branch.");
        System.out.println("Type " + '"' + 6 + '"' + " to quit banking and wake up.");
    }

    private static void addBranch() {
        System.out.println("Please enter the name of new branch:");
        String name = scanner.nextLine();
        boolean success = bank.addBranch(name);
        if (success) {
            System.out.println("Branch " + name + " was added successfully.");
        } else {
            System.out.println("Branch with the name " + '"' + name + '"' + " already exists.");
        }
    }

    private static void addCustomer() {
        System.out.println("Please enter a branch to which you would like to add a customer:");
        String branchName = scanner.nextLine();
        int branchIndex = bank.searchForBranch(branchName);
        if (branchIndex >= 0) {
            System.out.println("Please enter new customer name:");
            String customerName = scanner.nextLine();
            System.out.println("Please enter initial transaction amount:");
            double initialTransaction = scanner.nextDouble();
            scanner.nextLine();
            boolean success = bank.addNewCustomerToBranch(branchIndex, customerName, initialTransaction);
            if (success) {
                System.out.println("New customer " + '"' + customerName + '"' + " was added.");
            } else {
                System.out.println("Customer " + '"' + customerName + '"' + " already exists in " + '"' + branchName + '"' + " branch.");
            }
        } else {
            System.out.println("Branch with the name" + '"' + branchName + '"' + " does not exist.");
        }

    }

    private static void addTransactionToCustomer() {
        System.out.println("Please enter a branch in which you would like to operate:");
        String branchName = scanner.nextLine();
        int branchIndex = bank.searchForBranch(branchName);
        if (branchIndex >= 0) {
            System.out.println("Please enter existing customer name:");
            String customerName = scanner.nextLine();
            System.out.println("Please enter transaction amount:");
            double initialTransaction = scanner.nextDouble();
            scanner.nextLine();
            boolean success = bank.addTransactionToSpecificCustomer(branchIndex, customerName, initialTransaction);
            if (success) {
                System.out.println("New transaction to customer " + '"' + customerName + '"' + " was added.");
            } else {
                System.out.println("Customer " + '"' + customerName + '"' + " does not exist in " + '"' + branchName + '"' + " branch.");
            }
        } else {
            System.out.println("Branch with the name" + '"' + branchName + '"' + " does not exist.");
        }

    }

    private static void printCustomerList() {
        System.out.println("Please enter a branch in which you would like to operate:");
        String branchName = scanner.nextLine();
        System.out.println("Please specify if you would like to:\n" +
                "(Option #0): Print the list of customers;\n" +
                "(Option #1): Print the list of customers and their transactions.");
        System.out.println("Your Option:");
        int printTransactionOption = scanner.nextInt();
        scanner.nextLine();
        if (printTransactionOption == 0 || printTransactionOption == 1) {
            bank.printListOfBranchCustomers(branchName, printTransactionOption);
        } else {
            System.out.println("There is no option #" + printTransactionOption);
        }

    }

}



































