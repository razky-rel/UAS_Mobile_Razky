package com.example.uas_mobile;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EndemikAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchData();
    }

    private void fetchData() {
        ApiService apiService = ApiClient.getApiService();
        Call<List<EndemikModel>> call = apiService.getEndemikData();

        call.enqueue(new Callback<List<EndemikModel>>() {
            @Override
            public void onResponse(Call<List<EndemikModel>> call, Response<List<EndemikModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<EndemikModel> listEndemik = response.body();
                    adapter = new EndemikAdapter(MainActivity.this, listEndemik);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<EndemikModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Gagal mengambil data: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}