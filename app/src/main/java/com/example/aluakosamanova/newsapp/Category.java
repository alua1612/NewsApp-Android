package com.example.aluakosamanova.newsapp;

/**
 * Created by aluakosamanova on 03.10.17.
 */

public class Category {
    private String cName;
    private int imgSrc;

    public Category(){

    }

    public Category(String name, int img) {
        this.cName = name;
        this.imgSrc = img;
    }

    public String getName() {
        return cName;
    }

    public void setName(String name){
        this.cName=name;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int image){
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
