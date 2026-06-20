package com.example.uas_mobile;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "endemik_table")
public class EndemikModel {

    @PrimaryKey
    @NonNull
    @SerializedName("id")
    private String id;

    @SerializedName("tipe")
    private String tipe;

    @SerializedName("nama")
    private String nama;

    @SerializedName("nama_latin")
    private String nama_latin;

    @SerializedName("famili")
    private String famili;

    @SerializedName("genus")
    private String genus;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("foto")
    private String foto;

    private boolean isFavorite;


    public EndemikModel(@NonNull String id, String tipe, String nama, String nama_latin, String famili, String genus, String deskripsi, String foto, boolean isFavorite) {
        this.id = id;
        this.tipe = tipe;
        this.nama = nama;
        this.nama_latin = nama_latin;
        this.famili = famili;
        this.genus = genus;
        this.deskripsi = deskripsi;
        this.foto = foto;
        this.isFavorite = isFavorite;
    }

    @NonNull
    public String getId() { return id; }
    public String getTipe() { return tipe; }
    public String getNama() { return nama; }
    public String getNama_latin() { return nama_latin; }
    public String getFamili() { return famili; }
    public String getGenus() { return genus; }
    public String getDeskripsi() { return deskripsi; }
    public String getFoto() { return foto; }
    public boolean isFavorite() { return isFavorite; }
    public void setFavorite(boolean favorite) { isFavorite = favorite; }
}