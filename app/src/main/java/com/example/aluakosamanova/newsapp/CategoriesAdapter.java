package com.example.aluakosamanova.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class CategoriesAdapter extends
        RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public ImageView imgSrc;
        public TextView cName;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            imgSrc = (ImageView) itemView.findViewById(R.id.category_img);
            cName = (TextView) itemView.findViewById(R.id.category_name);
        }
    }
    private List<Category> mCategories;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public CategoriesAdapter(Context context, List<Category> categories) {
        mCategories = categories;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View categoryView = inflater.inflate(R.layout.item_category, parent, false);

        // Return a new holder instance
        CategoriesAdapter.ViewHolder viewHolder = new CategoriesAdapter.ViewHolder(categoryView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(CategoriesAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Category category = mCategories.get(position);

        // Set item views based on your views and data model
        ImageView imgView = viewHolder.imgSrc;
        imgView.setImageURI(category.getImgSrc());
        TextView txtView = viewHolder.cName;
        txtView.setText(category.getName());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCategories.size();
    }

}
