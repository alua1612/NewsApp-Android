package com.example.aluakosamanova.newsapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by aluakosamanova on 09.10.17.
 */

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contacts")
    List<Contact> getAll();

    @Insert
    void insert(Contact news);

    @Query("SELECT * FROM contacts")
    List<Contact> getAllNews();
}
