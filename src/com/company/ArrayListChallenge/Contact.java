package com.company.ArrayListChallenge;

public class Contact {
    private String name;
    private String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public boolean compareContact(String name, String number) {
        return (name.equals(this.name) && number.equals(this.number));
    }

    public boolean compareContact(String name) {
        return (name.equals(this.name));
    }


    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
