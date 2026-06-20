package com.example.uas_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EndemikAdapter adapter;
    private List<EndemikModel> allDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ImageView btnBack = findViewById(R.id.btnBack);
        SearchView searchView = findViewById(R.id.searchView);
        RecyclerView rvSearch = findViewById(R.id.rvSearch);

        AppDatabase db = AppDatabase.getInstance(this);
        allDataList = db.endemikDao().getAllEndemik();

        rvSearch.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new EndemikAdapter(this, new ArrayList<>(allDataList));
        rvSearch.setAdapter(adapter);

        btnBack.setOnClickListener(v -> finish());

        ImageView btnFavTop = findViewById(R.id.btnFavTop);

        btnFavTop.setOnClickListener(v -> {
            android.content.Intent intent = new android.content.Intent(SearchActivity.this, FavoriteActivity.class);
            startActivity(intent);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                saringData(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                saringData(newText);
                return true;
            }
        });
    }

    private void saringData(String kataKunci) {
        List<EndemikModel> hasilFilter = new ArrayList<>();

        for (EndemikModel item : allDataList) {
            if (item.getNama().toLowerCase().contains(kataKunci.toLowerCase()) ||
                    item.getNama_latin().toLowerCase().contains(kataKunci.toLowerCase())) {
                hasilFilter.add(item);
            }
        }
        adapter.updateList(hasilFilter);
    }
}