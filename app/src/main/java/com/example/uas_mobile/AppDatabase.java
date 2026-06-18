package com.example.uas_mobile;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {EndemikModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EndemikDao endemikDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AppDatabase.class, "endemik_database")
                            .allowMainThreadQueries() // Mengizinkan proses database di thread utama (khusus buat pemula/UAS biar gampang)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}