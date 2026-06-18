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

    @SerializedName("nama")
    private String nama;

    @SerializedName("deskripsi")
    private String deskripsi;

    @SerializedName("lokasi")
    private String lokasi;

    @SerializedName("foto")
    private String foto;

    @SerializedName("tipe")
    private String tipe;
    // Constructor
    public EndemikModel(@NonNull String id, String nama, String deskripsi, String lokasi, String foto, String tipe) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.foto = foto;
        this.tipe = tipe;
    }

    // Getter
    @NonNull
    public String getId() { return id; }
    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public String getFoto() { return foto; }
    public String getTipe() { return tipe; }
}