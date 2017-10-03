package com.example.aluakosamanova.newsapp;

import java.util.ArrayList;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class Category {
    private String cName;
    private String imgSrc;

    public Category(String name, String img) {
        cName = name;
        imgSrc = img;
    }

    public String getName() {
        return cName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    private static int lastCategoryId = 0;

    public static ArrayList<Category> createContactsList(int numCategories) {
        ArrayList<Category> categories = new ArrayList<Category>();

            categories.add(new Category("News & Politics" , "imgSrc"));

        return categories;
    }
}
