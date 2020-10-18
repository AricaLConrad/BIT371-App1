package com.example.practiceapp;

import java.util.ArrayList;

// This class is the object that represents each record in the contacts list.
// In the slides, this is referred to as, "Define the model class for the data."
public class Contact {

    // This is the name of the person in the contacts list.
    private String mName;
    // This stores if the person is online (true) or offline (false).
    private boolean mOnline;
    // This will keep track of how many people total are in the list.
    private static int lastContactId = 0;

    // The constructor, which takes in two values and sets it equal to the variables defined above.
    public Contact(String name, boolean online) {
        mName = name;
        mOnline = online;
    }

    // This returns the name of the person.
    public String getName() {
        return mName;
    }

    // This returns the online status of the person.
    public boolean isOnline() {
        return mOnline;
    }

    // This being a static method means that we do not create an instance of contacts.
    // The method gets passed in a certain number of people to put in the contact list.
    // A new ArrayList for the contacts is created, and for every person, a new record is
    // created with their name and their online/offline status, which is calculated.
    // The ArrayList is returned at the end of the method.
    public static ArrayList<Contact> createContactsList(int numContacts) {
        // Create the ArrayList.
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        // Create new contacts for each person. The person ID is based on the lastContactId variable,
        // which is incremented every time. The online/offline status of all of the contacts by the
        // end of the for loop will be split in half, with half of the people being online and half
        // of the people being offline.
        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        // Returns the ArrayList.
        return contacts;
    }
}
