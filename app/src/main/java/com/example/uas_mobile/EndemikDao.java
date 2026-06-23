package com.example.uas_mobile;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface EndemikDao {


    @Query("SELECT COUNT(*) FROM endemik_table")
    int getDataCount();
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EndemikModel> endemikList);

    @Query("SELECT * FROM endemik_table")
    List<EndemikModel> getAllEndemik();

    @Query("SELECT * FROM endemik_table WHERE id = :id")
    EndemikModel getEndemikById(String id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertFavorite(FavoriteModel favorite);

    @Query("DELETE FROM favorit_table WHERE id = :id")
    void deleteFavoriteById(String id);

    @Query("SELECT EXISTS(SELECT 1 FROM favorit_table WHERE id = :id)")
    boolean isFavorite(String id);

    @Query("SELECT endemik_table.* FROM endemik_table INNER JOIN favorit_table ON endemik_table.id = favorit_table.id")
    List<EndemikModel> getFavoriteEndemik();
}