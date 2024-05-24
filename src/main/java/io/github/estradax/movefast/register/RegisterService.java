package io.github.estradax.movefast.register;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public boolean isEmailExists(String email) {
    String sql = "SELECT COUNT(*) FROM penumpang WHERE email = ?";

    Integer length = jdbcTemplate.queryForObject(sql, Integer.class, email);
    return length >= 1;
  }

  public boolean register(RegisterForm registerForm) {
    if (isEmailExists(registerForm.getEmail())) {
      return false;
    }

    String sql = "INSERT INTO penumpang(nama, ttl, email, notlfn, alamat, password) VALUES(?, ?, ?, ?, ?, ?)";
    Integer count = jdbcTemplate.update(sql, registerForm.getName(), registerForm.getTtl(), registerForm.getEmail(), registerForm.getPhoneNumber(), registerForm.getAddress(), registerForm.getPassword());
    return count == 1;
  }
}
