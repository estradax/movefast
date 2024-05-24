package io.github.estradax.movefast.register;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RegisterForm {
  @NotBlank
  private String name;
  @NotNull
  private LocalDate ttl;
  @NotBlank
  private String phoneNumber;
  @NotBlank
  private String address;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String password;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public LocalDate getTtl() {
    return ttl;
  }

  public void setTtl(LocalDate ttl) {
    this.ttl = ttl;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
