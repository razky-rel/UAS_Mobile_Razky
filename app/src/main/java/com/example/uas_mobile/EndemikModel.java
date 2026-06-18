package com.example.uas_mobile;

import com.google.gson.annotations.SerializedName;

public class EndemikModel {
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

    // Constructor, Getter, dan Setter
    public EndemikModel(String id, String nama, String deskripsi, String lokasi, String foto) {
        this.id = id;
        this.nama = nama;
        this.deskripsi = deskripsi;
        this.lokasi = lokasi;
        this.foto = foto;
    }

    public String getNama() { return nama; }
    public String getDeskripsi() { return deskripsi; }
    public String getLokasi() { return lokasi; }
    public String getFoto() { return foto; }
}