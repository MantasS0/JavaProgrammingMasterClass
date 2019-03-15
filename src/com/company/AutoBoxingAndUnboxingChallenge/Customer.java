package com.company.AutoBoxingAndUnboxingChallenge;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList<Double>();

    public Customer(String name, Double initialTransaction) {
        this.name = name;
        this.transactions.add(initialTransaction);
    }

    public void addTransaction(double value) {
            this.transactions.add(value);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
