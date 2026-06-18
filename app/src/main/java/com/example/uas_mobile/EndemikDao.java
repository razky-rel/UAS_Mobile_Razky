package com.example.uas_mobile;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface EndemikDao {

    //  menyimpan banyak data sekaligus dari API ke lokal
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<EndemikModel> endemikList);

    //  mengambil semua data dari database lokal
    @Query("SELECT * FROM endemik_table")
    List<EndemikModel> getAllEndemik();

    // mengecek jumlah data
    @Query("SELECT COUNT(*) FROM endemik_table")
    int getDataCount();
}