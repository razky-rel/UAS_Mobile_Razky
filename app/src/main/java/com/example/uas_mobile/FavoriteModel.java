package com.example.uas_mobile;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorit_table")
public class FavoriteModel {

    @PrimaryKey
    @NonNull
    private String id;


    public FavoriteModel(@NonNull String id) {
        this.id = id;
    }


    @NonNull
    public String getId() {
        return id;
    }
}