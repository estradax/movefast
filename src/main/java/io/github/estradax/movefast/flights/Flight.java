package io.github.estradax.movefast.flights;

import java.sql.Timestamp;

public class Flight {
  private Timestamp waktuberangkat;
  private Timestamp waktutiba;
  private String nama_maskapai;
  private String jenis_pesawat;

  public Timestamp getWaktuberangkat() {
    return waktuberangkat;
  }

  public void setWaktuberangkat(Timestamp waktuberangkat) {
    this.waktuberangkat = waktuberangkat;
  }

  public Timestamp getWaktutiba() {
    return waktutiba;
  }

  public void setWaktutiba(Timestamp waktutiba) {
    this.waktutiba = waktutiba;
  }

  public String getNama_maskapai() {
    return nama_maskapai;
  }

  public void setNama_maskapai(String nama_maskapai) {
    this.nama_maskapai = nama_maskapai;
  }

  public String getJenis_pesawat() {
    return jenis_pesawat;
  }

  public void setJenis_pesawat(String jenis_pesawat) {
    this.jenis_pesawat = jenis_pesawat;
  }
}
