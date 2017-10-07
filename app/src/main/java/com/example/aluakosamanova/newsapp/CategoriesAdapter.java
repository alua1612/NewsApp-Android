package com.example.aluakosamanova.newsapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class CategoriesAdapter extends
        RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    private List<Category> mCategories;
    private Context mContext;

    public CategoriesAdapter(Context context, List<Category> categories) {
        mCategories = categories;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgSrc;
        public TextView cName;

        public ViewHolder(View itemView) {
            super(itemView);

            imgSrc = (ImageView) itemView.findViewById(R.id.category_img);
            cName = (TextView) itemView.findViewById(R.id.category_name);
        }
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public CategoriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View categoryView = inflater.inflate(R.layout.item_category, parent, false);

        CategoriesAdapter.ViewHolder viewHolder = new CategoriesAdapter.ViewHolder(categoryView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CategoriesAdapter.ViewHolder viewHolder, int position) {
        Category category = mCategories.get(position);

        ImageView imgView = viewHolder.imgSrc;
        imgView.setImageResource(category.getImgSrc());
        TextView txtView = viewHolder.cName;
        txtView.setText(category.getName());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mCategories.size();
    }

}
