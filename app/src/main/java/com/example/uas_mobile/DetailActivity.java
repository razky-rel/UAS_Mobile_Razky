package com.example.uas_mobile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private AppDatabase db;
    private EndemikModel endemikItem;
    private ImageView btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String id = getIntent().getStringExtra("id");
        ImageView btnBack = findViewById(R.id.btnBack);
        db = AppDatabase.getInstance(this);
        endemikItem = db.endemikDao().getEndemikById(id);

        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView tvNama = findViewById(R.id.tvNamaDetail);
        TextView tvNamaLatin = findViewById(R.id.tvNamaLatinDetail);
        TextView tvFamili = findViewById(R.id.tvFamiliDetail);
        TextView tvGenus = findViewById(R.id.tvGenusDetail);
        TextView tvDesc = findViewById(R.id.tvDescDetail);
        btnFavorite = findViewById(R.id.btnFavorite);

        btnBack.setOnClickListener(v -> finish());

        if (endemikItem != null) {
            tvNama.setText(endemikItem.getNama());
            tvDesc.setText(endemikItem.getDeskripsi());
            tvNamaLatin.setText(endemikItem.getNama_latin());
            tvFamili.setText("Famili: " + endemikItem.getFamili());
            tvGenus.setText("Genus: " + endemikItem.getGenus());

            Glide.with(this)
                    .load(endemikItem.getFoto())
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imgDetail);

            boolean isFavSaatIni = db.endemikDao().isFavorite(id);
            updateIconFavorite(isFavSaatIni);

            btnFavorite.setOnClickListener(v -> {
                boolean statusTerkini = db.endemikDao().isFavorite(id);

                if (statusTerkini) {
                    db.endemikDao().deleteFavoriteById(id);
                    updateIconFavorite(false);
                    Toast.makeText(DetailActivity.this, "Dihapus dari Favorit", Toast.LENGTH_SHORT).show();
                } else {
                    db.endemikDao().insertFavorite(new FavoriteModel(id));
                    updateIconFavorite(true);
                    Toast.makeText(DetailActivity.this, "Dimasukkan ke Favorit", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    private void updateIconFavorite(boolean isFav) {
        if (isFav) {
            btnFavorite.setImageResource(android.R.drawable.btn_star_big_on); // Bintang Kuning Menyala
        } else {
            btnFavorite.setImageResource(android.R.drawable.btn_star_big_off); // Bintang Kosong Abu-abu
        }
    }
}