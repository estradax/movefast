package io.github.estradax.movefast.penumpang;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PenumpangMapper implements RowMapper<Penumpang> {

  @Override
  public Penumpang mapRow(ResultSet rs, int rowNum) throws SQLException {
    Penumpang penumpang = new Penumpang();
    penumpang.setIdpenumpang(rs.getInt("idpenumpang"));
    penumpang.setNama(rs.getString("nama"));
    penumpang.setTtl(rs.getDate("ttl").toLocalDate());
    penumpang.setEmail(rs.getString("email"));
    penumpang.setNotlfn(rs.getString("notlfn"));
    penumpang.setAlamat(rs.getString("alamat"));
    penumpang.setPassword(rs.getString("password"));
    penumpang.setIdpesawat(rs.getInt("idpesawat"));
    penumpang.setIdtransaksi(rs.getInt("idtransaksi"));
    penumpang.setIdjadwal(rs.getInt("idjadwal"));

    return penumpang;
  }
}
