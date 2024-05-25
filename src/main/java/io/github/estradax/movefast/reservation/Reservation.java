package io.github.estradax.movefast.reservation;

import java.time.LocalDate;

public class Reservation {
  private Integer idtransaksi;
  private String rute;
  private String kelas;
  private Integer harga;
  private LocalDate tanggaltf;
  private Integer idpesawat;

  public Integer getIdtransaksi() {
    return idtransaksi;
  }

  public void setIdtransaksi(Integer idtransaksi) {
    this.idtransaksi = idtransaksi;
  }

  public String getRute() {
    return rute;
  }

  public void setRute(String rute) {
    this.rute = rute;
  }

  public String getKelas() {
    return kelas;
  }

  public void setKelas(String kelas) {
    this.kelas = kelas;
  }

  public Integer getHarga() {
    return harga;
  }

  public void setHarga(Integer harga) {
    this.harga = harga;
  }

  public LocalDate getTanggaltf() {
    return tanggaltf;
  }

  public void setTanggaltf(LocalDate tanggaltf) {
    this.tanggaltf = tanggaltf;
  }

  public Integer getIdpesawat() {
    return idpesawat;
  }

  public void setIdpesawat(Integer idpesawat) {
    this.idpesawat = idpesawat;
  }
}
