package com.example.aluakosamanova.newsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by aluakosamanova on 09.10.17.
 */

public class ContactByIdActivity  extends AppCompatActivity {
    private Contact curContact;
    private View v;
    private ContactsAdapter adapter;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    Intent i;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_by_id);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        v = getWindow().getDecorView().getRootView();
        i = getIntent();
        curContact = (Contact) i.getParcelableExtra("news-item");

        TextView newsTitle = (TextView)findViewById(R.id.title);
        TextView newsBody = (TextView)findViewById(R.id.body);
        TextView newsDate = (TextView)findViewById(R.id.date);
        newsTitle.setText(curContact.getTitle());
        newsBody.setText(curContact.getBody());
        newsDate.setText(curContact.getDate());

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("News");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item);
    }
}
