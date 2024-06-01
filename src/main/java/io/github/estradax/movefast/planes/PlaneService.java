package io.github.estradax.movefast.planes;

import io.github.estradax.movefast.admin.planes.PlaneUpdateForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaneService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Plane> findAll() {
    String sql = "SELECT * FROM pesawat";
    return jdbcTemplate.query(sql, new PlaneMapper());
  }

  public Plane findById(Integer id) {
    String sql = "SELECT * FROM pesawat WHERE idpesawat = ?";
    return jdbcTemplate.queryForObject(sql, new PlaneMapper(), id);
  }

  public void update(Integer id, PlaneUpdateForm planeUpdateForm) {
    String sql = "UPDATE pesawat SET nama_maskapai = ?, jenis_pesawat = ? WHERE idpesawat = ?";
    jdbcTemplate.update(sql, planeUpdateForm.getNamaMaskapai(), planeUpdateForm.getJenisPesawat(), id);
  }

  public void delete(Integer id) {
    String sql = "DELETE FROM pesawat WHERE idpesawat = ?";
    jdbcTemplate.update(sql, id);
  }
}
