package io.github.estradax.movefast.planes;

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
}
