package com.example.aluakosamanova.newsapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aluakosamanova.newsapp.CategoriesAdapter;
import com.example.aluakosamanova.newsapp.Category;
import com.example.aluakosamanova.newsapp.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentTwo extends Fragment {

    private RecyclerView recyclerview;
    private CategoriesAdapter categoriesadapter;
    private List<Category> categoryList;

    public FragmentTwo() {
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
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        recyclerview = view.findViewById(R.id.rvCategories);
        categoryList = new ArrayList<>();
        categoriesadapter = new CategoriesAdapter(this.getContext(), categoryList);
        recyclerview.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
//        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(categoriesadapter);

        Category c = new Category("Fashion", R.drawable.fash);
        categoryList.add(c);

        c=new Category("Technology", R.drawable.tech);
        categoryList.add(c);

        c=new Category("World news", R.drawable.world);
        categoryList.add(c);

        c=new Category("Agriculture", R.drawable.agri);
        categoryList.add(c);

        c=new Category("Sport", R.drawable.sportnews);
        categoryList.add(c);
        categoriesadapter.notifyDataSetChanged();

        return view;
    }
}

