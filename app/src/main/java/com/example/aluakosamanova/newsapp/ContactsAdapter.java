package com.example.aluakosamanova.newsapp;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder> {

    private List<Contact> mContacts;
    private Context mContext;

    public ContactsAdapter(Context context, List<Contact> contacts) {
        mContacts = contacts;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameTextView;
        public TextView bodyView;
        public TextView dateView;
        int position;

        public ViewHolder(View itemView, final Context event) {
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            dateView = (TextView) itemView.findViewById(R.id.contact_date);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(event, ContactByIdActivity.class);
                    intent.putExtra("news-item", (Parcelable) mContacts.get(position));
                    event.startActivity(intent);
                }
            });
        }
        public void setPosition(int position) {
            this.position = position;
        }
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        ViewHolder viewHolder = new ViewHolder(contactView, mContext);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
        Contact contact = mContacts.get(position);
        viewHolder.setPosition(position);
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getTitle());
        TextView txtView = viewHolder.dateView;
        txtView.setText(contact.getDate());
//        TextView texttView = viewHolder.bodyView;
//        texttView.setText(contact.getBody());
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }

    public void insert(int position, Contact contacts) {
        mContacts.add(position, contacts);
        notifyItemInserted(position);
    }


}