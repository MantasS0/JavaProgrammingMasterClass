package com.company.ArrayListChallenge;


import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private boolean flag = true;

    public void run() {
        printOptionList();
        while (flag) {
            System.out.println("Please select action number: ");
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 1:
                    printOptionList();
                    break;
                case 2:
                    printListOfContacts();
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    findContact();
                    break;
                case 5:
                    updateContact();
                    break;
                case 6:
                    removeContact();
                    break;
                case 7:
                    quit();
                    break;
                default:
                    System.out.println("Wrong action number.");
                    break;
            }
        }
    }

    private void printOptionList() {
        System.out.println("Mobile phone options listed bellow. Press:");
        System.out.println("#1 - Instructions.");
        System.out.println("#2 - Contact list.");
        System.out.println("#3 - Add a contact.");
        System.out.println("#4 - Search for contact.");
        System.out.println("#5 - Update a contact.");
        System.out.println("#6 - Remove a contact.");
        System.out.println("#7 - Quit.");
    }

    private void printListOfContacts() {
        if (!contacts.isEmpty()) {
            String format = "%1$-15s|%2$15s";
            System.out.format(format,"Name", "Phone Number");
            System.out.println();
//            System.out.println("  Name  | Phone number ");
            for (Contact contact1 : contacts) {
                String name = contact1.getName();
                if (name.length() > 15) {
                    String shortName = "";
                    for (int i = 0; i < 12; i++) {
                        shortName += name.charAt(i);
                    }
                    shortName += "...";
                    name = shortName;
                }
                System.out.format(format, name, contact1.getNumber());
                System.out.println();
//                System.out.println(contact1.getName() + " | " + contact1.getNumber());
            }
        } else {
            System.out.println("No contacts found.");
        }
    }

    private void addContact() {
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        if (searchContact(name) == null) {
            System.out.println("Please enter phone number: ");
            String number = scanner.nextLine();
            contacts.add(new Contact(name, number));
            System.out.println("Contact " + '"' + name + '"' + " was added successfully.");
        } else {
            System.out.println("There is a contact with the same name.");
        }
    }

    private void findContact() {
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        Contact contact = searchContact(name);
        if (contact != null) {
            System.out.println("Contact found.");
            System.out.println("Name: " + contact.getName() + " | Phone number: " + contact.getNumber());
        } else {
            System.out.println("Contact not found.");
        }
    }

    private Contact searchContact(String name) {
        for (Contact contact1 : contacts) {
            if (contact1.compareContact(name)) {
                return contact1;
            }
        }
        return null;
    }

    private void updateContact() {
        System.out.println("Please enter name:");
        String oldName = scanner.nextLine();
        Contact contactToEdit = searchContact(oldName);
        if (contactToEdit != null) {
            System.out.println("Please enter new name:");
            String newName = scanner.nextLine();
            if (searchContact(newName)!=null){
                System.out.println("Contact " + newName + " already exists.");
                return;
            }
            System.out.println("Please enter new phone number:");
            String newPhoneNumber = scanner.nextLine();
            int index = contacts.indexOf(contactToEdit);
            contacts.set(index, new Contact(newName, newPhoneNumber));
            System.out.println("Contact was updated.");
        } else {
            System.out.println("No contact by the name " + oldName + " was found.");
        }
    }

    private void removeContact() {
        System.out.println("Please enter name:");
        String name = scanner.nextLine();
        if (removeContact(name)) {
            System.out.println(name + " was removed from contacts.");
        } else {
            System.out.println(name + " was not found in contact list.");
        }
    }

    private boolean removeContact(String name) {
        Contact contactToRemove = searchContact(name);
        if (contactToRemove != null) {
            contacts.remove(contactToRemove);
            return true;
        }
        return false;
    }

    private void quit() {
        flag = false;
    }
}
