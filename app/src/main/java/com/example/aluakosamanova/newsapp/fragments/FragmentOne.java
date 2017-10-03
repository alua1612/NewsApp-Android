package com.example.aluakosamanova.newsapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aluakosamanova.newsapp.Contact;
import com.example.aluakosamanova.newsapp.ContactsAdapter;
import com.example.aluakosamanova.newsapp.R;

import java.util.ArrayList;

public class FragmentOne extends Fragment {
    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvContacts);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        contacts.add(new Contact("News & Politics" , true));
        contacts.add(new Contact("Sports" , true));
        contacts.add(new Contact("Travel" , true));
        contacts.add(new Contact("Health" , true));
        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), contacts);
        recyclerView.setAdapter(contactsAdapter);
        return view;
    }

}
