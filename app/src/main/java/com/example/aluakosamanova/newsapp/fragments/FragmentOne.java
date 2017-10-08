package com.example.aluakosamanova.newsapp.fragments;

import android.arch.persistence.room.Room;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.aluakosamanova.newsapp.AppDatabase;
import com.example.aluakosamanova.newsapp.Contact;
import com.example.aluakosamanova.newsapp.ContactsAdapter;
import com.example.aluakosamanova.newsapp.R;

import java.util.List;

import static com.example.aluakosamanova.newsapp.R.id.fab_news;

public class FragmentOne extends Fragment {
    private RecyclerView recyclerview;
    private ContactsAdapter contactsAdapter;
    private List<Contact> contactList;
    private AlertDialog.Builder alertDialog;
    private boolean add = false;
    AppDatabase database;
    View view;
    public FragmentOne() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = Room.databaseBuilder(getActivity().getApplicationContext(), AppDatabase.class, "Room.db").build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_one, container, false);
        recyclerview = (RecyclerView) view.findViewById(R.id.rvContacts);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(fab_news);
        fab.setOnClickListener((View.OnClickListener) this);

        alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setView(inflater.inflate(R.layout.news_create, null));
        alertDialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(add) {
                    add = false;
                    EditText title = (EditText) view.findViewById(R.id.cr_title);
                    EditText body = (EditText) view.findViewById(R.id.cr_body);
                    EditText date = (EditText) view.findViewById(R.id.cr_date);
                    Contact crNews = new Contact(title.getText().toString(), body.getText().toString(), date.getText().toString());
                    contactsAdapter.insert(contactList.size(), crNews);
                    AddNews(crNews);
                    contactsAdapter.notifyDataSetChanged();
                    dialog.dismiss();
                }
            }
        });

        initSwipe();
        new GetNewsAsync().execute();
        return view;
    }
    private void initSwipe(){
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerview);
    }

    private void removeView(){
        if(view.getParent()!=null) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
    public void AddNews(Contact _news){
        new InsertAsync().execute(_news);
    }

//    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case fab_news:
                removeView();
                add = true;
                alertDialog.setTitle("Add News");
                alertDialog.show();
                break;
        }
    }


    private class GetNewsAsync extends AsyncTask<Void, Void, List <Contact>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List <Contact> doInBackground(Void... voids) {
            return database.newsDao().getAll();
        }

        @Override
        protected void onPostExecute(List <Contact> myList) {
            super.onPostExecute(myList);
            setToRecyclerView(myList);
        }
    }
    void setToRecyclerView(List <Contact> myList) {
        contactList = myList;
        contactsAdapter = new ContactsAdapter(this.getContext(), contactList);
        recyclerview.setLayoutManager(new GridLayoutManager(this.getContext(), 1));
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(contactsAdapter);
    }

    private class InsertAsync extends AsyncTask<Contact, Void, Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Contact ... crNews) {
            database.newsDao().insert(crNews[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
