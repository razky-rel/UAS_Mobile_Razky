package com.example.uas_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class FavoriteActivity extends AppCompatActivity {

    private RecyclerView rvFavorite;
    private EndemikAdapter adapter;
    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        ImageView btnBackFav = findViewById(R.id.btnBackFav);
        rvFavorite = findViewById(R.id.rvFavorite);
        db = AppDatabase.getInstance(this);

        rvFavorite.setLayoutManager(new GridLayoutManager(this, 2));

        adapter = new EndemikAdapter(this, new ArrayList<>());
        rvFavorite.setAdapter(adapter);

        btnBackFav.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<EndemikModel> favList = db.endemikDao().getFavoriteEndemik();

        adapter.updateList(favList);
    }
}