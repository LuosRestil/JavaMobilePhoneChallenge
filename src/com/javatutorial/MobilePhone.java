package com.javatutorial;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePhone {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private Scanner scanner = new Scanner(System.in);

    public void turnOn(){
        boolean quit = false;
        while (!quit) {
            System.out.println();
            System.out.println("***** MENU *****");
            System.out.println("1 - View contacts");
            System.out.println("2 - Add new contact");
            System.out.println("3 - Update existing contact");
            System.out.println("4 - Remove contact");
            System.out.println("5 - Search for contact");
            System.out.println("6 - Quit");
            System.out.print("Select an option: ");
            int selection = scanner.nextInt();
            scanner.nextLine();
            switch (selection) {
                case 1:
                    printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    searchContacts();
                    break;
                case 6:
                    System.out.println("Goodbye.");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid input. Please choose an option from the menu.");
                    break;
            }
        }
    }


    public void printContacts(){
        if (contacts.size() > 0){
            for (Contact contact : contacts) {
                contact.printContact();
            }
        } else {
            System.out.println("Contacts list empty.");
        }

    }

    private void addContact(){
        System.out.print("Add - Enter contact name: ");
        String name = scanner.nextLine();
        if (contactExists(name)) {
            System.out.println(String.format("Contact with name \"%s\" already exists.", name));
        } else {
            System.out.print("Add - Enter contact phone number: ");
            String number = scanner.nextLine();
            contacts.add(new Contact(name, number));
            System.out.println("Contact added.");
        }
    }

    private int contactLocation(String name){
        for (int i = 0; i < contacts.size(); i++){
            if (contacts.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    private boolean contactExists(String name){
        return contactLocation(name) > -1;
    }

    private void updateContact(){
        System.out.print("Update - Enter name of contact to change: ");
        String originalName = scanner.nextLine();
        if (contactExists(originalName)) {
            System.out.print("Update - Enter new contact name: ");
            String newName = scanner.nextLine();
            if (contactExists(newName)) {
                System.out.println(String.format("A contact with name \"%s\" already exists.", newName));
            } else {
                System.out.print("Update - Enter contact number: ");
                String number = scanner.nextLine();
                int loc = contactLocation(originalName);
                contacts.get(loc).update(newName, number);
                System.out.println("Contact updated.");
            }
        } else {
            notFoundMessage(originalName);
        }
    }

    private void removeContact(){
        System.out.print("Remove - Enter contact: ");
        String name = scanner.nextLine();
        if (contactExists(name)) {
            int loc = contactLocation(name);
            contacts.remove(loc);
            System.out.println("Contact removed.");
        } else {
            notFoundMessage(name);
        }
    }

    private void searchContacts(){
        System.out.print("Search - Enter contact name: ");
        String name = scanner.nextLine();
        if (contactExists(name)){
            int loc = contactLocation(name);
            System.out.println(String.format("Contact found. Number: %s", contacts.get(loc).getNumber()));
        } else {
            notFoundMessage(name);
        }
    }

    private void notFoundMessage(String name){
        System.out.println(String.format("No contact with name \"%s\" found.", name));
    }
}
