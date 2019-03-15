package com.company.AutoBoxingAndUnboxingChallenge;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<Customer>();

    public Branch(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean addCustomer(Customer customer) {
        if (!this.customers.contains(customer)) {
            this.customers.add(customer);
            return true;
        } else {
            return false;
        }
    }

    public boolean addTransactionToCustomer(String name, double transactionValue) {
        int customerIndex = searchForCustomer(name);
        if (customerIndex >= 0) {
            this.customers.get(customerIndex).addTransaction(transactionValue);
            return true;
        } else {
            return false;
        }
    }

    public int searchForCustomer(String name) {
        for (int i = 0; i < this.customers.size(); i++) {
            if (customers.get(i).getName().equals(name)) {
                return customers.indexOf(customers.get(i));
            }
        }
        return -1;
    }
}
