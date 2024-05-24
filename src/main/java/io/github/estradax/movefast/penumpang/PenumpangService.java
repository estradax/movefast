package io.github.estradax.movefast.penumpang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PenumpangService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Penumpang findByEmail(String email) {
    String sql = "SELECT * FROM penumpang WHERE email = ?";

    Penumpang penumpang = null;
    try {
      penumpang = jdbcTemplate.queryForObject(sql, new PenumpangMapper(), email);
    } catch (EmptyResultDataAccessException e) {
      penumpang = null;
    }

    return penumpang;
  }
}
