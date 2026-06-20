package com.example.uas_mobile;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface EndemikDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EndemikModel> endemikList);

    @Query("SELECT * FROM endemik_table")
    List<EndemikModel> getAllEndemik();

    @Query("SELECT COUNT(*) FROM endemik_table")
    int getDataCount();

    @Query("SELECT * FROM endemik_table WHERE id = :id")
    EndemikModel getEndemikById(String id);

    @Update
    void updateEndemik(EndemikModel endemik);

    @Query("SELECT * FROM endemik_table WHERE isFavorite = 1")
    List<EndemikModel> getFavoriteEndemik();
}