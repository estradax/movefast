package io.github.estradax.movefast.penumpang;

import java.time.LocalDate;

public class Penumpang {
  private Integer idpenumpang;
  private String nama;
  private LocalDate ttl;
  private String email;
  private String notlfn;
  private String alamat;
  private String password;
  private Integer idpesawat;
  private Integer idtransaksi;
  private Integer idjadwal;

  public Integer getIdpenumpang() {
    return idpenumpang;
  }

  public void setIdpenumpang(Integer idpenumpang) {
    this.idpenumpang = idpenumpang;
  }

  public String getNama() {
    return nama;
  }

  public void setNama(String nama) {
    this.nama = nama;
  }

  public LocalDate getTtl() {
    return ttl;
  }

  public void setTtl(LocalDate ttl) {
    this.ttl = ttl;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNotlfn() {
    return notlfn;
  }

  public void setNotlfn(String notlfn) {
    this.notlfn = notlfn;
  }

  public String getAlamat() {
    return alamat;
  }

  public void setAlamat(String alamat) {
    this.alamat = alamat;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getIdpesawat() {
    return idpesawat;
  }

  public void setIdpesawat(Integer idpesawat) {
    this.idpesawat = idpesawat;
  }

  public Integer getIdtransaksi() {
    return idtransaksi;
  }

  public void setIdtransaksi(Integer idtransaksi) {
    this.idtransaksi = idtransaksi;
  }

  public Integer getIdjadwal() {
    return idjadwal;
  }

  public void setIdjadwal(Integer idjadwal) {
    this.idjadwal = idjadwal;
  }
}
