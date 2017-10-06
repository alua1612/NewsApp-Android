package com.example.aluakosamanova.newsapp;

import com.orm.SugarRecord;

import java.util.ArrayList;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class Contact extends SugarRecord<Contact> {
    String mName;
    boolean mOnline;

    public Contact(){

    }
    public Contact(String name, boolean online) {
        this.mName = name;
        this.mOnline = online;
    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static ArrayList<Contact> createContactsList(int numContacts) {
        ArrayList<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
