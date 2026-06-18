package com.example.uas_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Ambil data yang dikirim dari MainActivity
        String nama = getIntent().getStringExtra("nama");
        String desc = getIntent().getStringExtra("deskripsi");
        String foto = getIntent().getStringExtra("foto");

        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView tvNama = findViewById(R.id.tvNamaDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);

        tvNama.setText(nama);
        tvDesc.setText(desc);
        Glide.with(this).load(foto).into(imgDetail);
    }
}