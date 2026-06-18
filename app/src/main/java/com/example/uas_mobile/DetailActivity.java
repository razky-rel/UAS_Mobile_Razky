package com.example.uas_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String nama = getIntent().getStringExtra("nama");
        String nama_latin = getIntent().getStringExtra("nama_latin"); // Tambahan
        String famili = getIntent().getStringExtra("famili"); // Tambahan
        String genus = getIntent().getStringExtra("genus"); // Tambahan
        String desc = getIntent().getStringExtra("deskripsi");
        String foto = getIntent().getStringExtra("foto");

        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView tvNama = findViewById(R.id.tvNamaDetail);
        TextView tvNamaLatin = findViewById(R.id.tvNamaLatinDetail);
        TextView tvFamili = findViewById(R.id.tvFamiliDetail);
        TextView tvGenus = findViewById(R.id.tvGenusDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);

        tvNama.setText(nama);
        tvDesc.setText(desc);

        if (nama_latin != null) tvNamaLatin.setText(nama_latin);
        if (famili != null) tvFamili.setText("Famili: " + famili);
        if (genus != null) tvGenus.setText("Genus: " + genus);

        Glide.with(this)
                .load(foto)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imgDetail);
    }
}