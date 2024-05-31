package io.github.estradax.movefast.planes;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaneMapper implements RowMapper<Plane> {
  @Override
  public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
    Plane plane = new Plane();
    plane.setIdpesawat(rs.getInt("idpesawat"));
    plane.setNama_maskapai(rs.getString("nama_maskapai"));
    plane.setJenis_pesawat(rs.getString("jenis_pesawat"));
    return plane;
  }
}
