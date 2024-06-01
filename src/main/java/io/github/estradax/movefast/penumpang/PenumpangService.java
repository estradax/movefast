package io.github.estradax.movefast.penumpang;

import io.github.estradax.movefast.admin.users.UserUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

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

  public void update(Integer id, UserUpdateForm userUpdateForm) {
    String sql = "UPDATE penumpang SET nama = ?, email = ?, notlfn = ?, alamat = ? WHERE idpenumpang = ?";
    jdbcTemplate.update(sql, userUpdateForm.getNama(), userUpdateForm.getEmail(), userUpdateForm.getPhoneNumber(), userUpdateForm.getAddress(), id);
  }

  public Penumpang findById(Integer id) {
    String sql = "SELECT * FROM penumpang WHERE idpenumpang = ?";

    Penumpang penumpang = null;
    try {
      penumpang = jdbcTemplate.queryForObject(sql, new PenumpangMapper(), id);
    } catch (EmptyResultDataAccessException e) {
      penumpang = null;
    }

    return penumpang;
  }

  public List<Penumpang> findAll() {
    String sql = "SELECT * FROM penumpang";
    return jdbcTemplate.query(sql, new PenumpangMapper());
  }

  public void delete(Integer id) {
    String sql = "DELETE FROM penumpang WHERE idpenumpang = ?";
    jdbcTemplate.update(sql, id);
  }
}
