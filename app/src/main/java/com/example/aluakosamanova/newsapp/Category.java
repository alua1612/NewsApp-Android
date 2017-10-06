package com.example.aluakosamanova.newsapp;

import com.orm.SugarRecord;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class Category extends SugarRecord<Category> {
    private String cName;
    private String imgSrc;

    public Category(){

    }

    public Category(String name, String img) {
        this.cName = name;
        this.imgSrc = img;
    }

    public String getName() {
        return cName;
    }

    public void setName(String name){
        this.cName=name;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String image){
        imgSrc=image;
    }

//    private static int lastCategoryId = 0;
//
//    public static ArrayList<Category> createContactsList(int numCategories) {
//        ArrayList<Category> categories = new ArrayList<Category>();
//
//            categories.add(new Category("News & Politics" , "imgSrc"));
//
//        return categories;
//    }
}
