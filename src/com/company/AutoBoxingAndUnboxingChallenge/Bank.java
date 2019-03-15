package com.company.AutoBoxingAndUnboxingChallenge;

import java.util.ArrayList;

public class Bank {

    private ArrayList<Branch> branches = new ArrayList<Branch>();


    public boolean addBranch(String name) {
        System.out.println(name);
        if (searchForBranch(name) < 0) {
        this.branches.add(new Branch(name));
        return true;
        } else {
            return false;
        }
    }

    public boolean addNewCustomerToBranch(int branchIndex, String customerName, double initialTransaction) {
//        int branchIndex = searchForBranch(branchName);
//        if (branchIndex >= 0) {
        Branch branch = this.branches.get(branchIndex);
        if (branch.searchForCustomer(customerName) == -1) {
            branch.addCustomer(new Customer(customerName, initialTransaction));
            return true;
        }
//        }
        return false;
    }

    public boolean addTransactionToSpecificCustomer(int branchIndex, String customerName, double transactionAmount) {
//        int branchIndex = searchForBranch(branchName);
//        if (branchIndex >= 0) {
        int customerIndex = branches.get(branchIndex).searchForCustomer(customerName);
        if (customerIndex >= 0) {
            branches.get(branchIndex).addTransactionToCustomer(customerName, transactionAmount);
            return true;
        }
//        }
        return false;
    }

    public int searchForBranch(String name) {
        if (this.branches != null) {
            for (int i = 0; i < this.branches.size(); i++) {
                if (branches.get(i).getName().equals(name)) {
                    return branches.indexOf(branches.get(i));
                }
            }
        }
        return -1;
    }

    public void printListOfBranchCustomers(String branchName, int printTransactions) {
        int branchIndex = searchForBranch(branchName);
        if (branchIndex >= 0) {
            if (printTransactions == 0) {
                System.out.println("Printing customers of " + branchName + " branch:");
                ArrayList<Customer> customerList = new ArrayList<Customer>(branches.get(branchIndex).getCustomers());
                for (int i = 0; i < customerList.size(); i++) {
                    System.out.print(i + 1 + ". " + customerList.get(i).getName());
                    if (i == customerList.size() - 1) {
                        System.out.println(".");
                    } else {
                        System.out.println(";");
                    }
                }
            } else if (printTransactions == 1) {
                System.out.println("Printing customers and customer transactions of " + branchName + " branch:");
                ArrayList<Customer> customerList = new ArrayList<Customer>(branches.get(branchIndex).getCustomers());
                for (int i = 0; i < customerList.size(); i++) {
                    System.out.println(i + 1 + ". " + customerList.get(i).getName() + ".\nTransactions as follows:");
                    ArrayList<Double> transactionList = new ArrayList<Double>(customerList.get(i).getTransactions());
                    double sum = 0;
                    for (int j = 0; j < transactionList.size(); j++) {
                        System.out.print("    " + (j + 1) + ". " + transactionList.get(j));
                        sum += transactionList.get(j);
                        if (j == transactionList.size() - 1) {
                            System.out.println(".");
                        } else {
                            System.out.println(";");
                        }

                    }
                    System.out.println("    Current balance: " + sum + "$");
                }
            }
        } else {
            System.out.println("Branch by the name " + '"' + branchName + '"' + " was not found.");
        }

    }
}
