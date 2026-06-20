package com.example.uas_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {

    private AppDatabase db;
    private Button btnLanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        btnLanjut = findViewById(R.id.btnLanjut);
        db = AppDatabase.getInstance(this);

        int dataCount = db.endemikDao().getDataCount();

        if (dataCount > 0) {
            new android.os.Handler().postDelayed(this::pindahKeHome, 1500);
        } else {
            fetchDataDariApi();
        }

        btnLanjut.setOnClickListener(v -> pindahKeHome());
    }

    private void fetchDataDariApi() {
        ApiService apiService = ApiClient.getApiService();
        Call<List<EndemikModel>> call = apiService.getEndemikData();

        call.enqueue(new Callback<List<EndemikModel>>() {
            @Override
            public void onResponse(Call<List<EndemikModel>> call, Response<List<EndemikModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<EndemikModel> dataList = response.body();
                    db.endemikDao().insertAll(dataList);

                    btnLanjut.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(SplashActivity.this, "Gagal memproses data server", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EndemikModel>> call, Throwable t) {
                Toast.makeText(SplashActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pindahKeHome() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}