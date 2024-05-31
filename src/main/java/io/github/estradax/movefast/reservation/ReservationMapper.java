package io.github.estradax.movefast.reservation;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper {
  @Override
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    Reservation reservation = new Reservation();
    reservation.setIdtransaksi(rs.getInt("idtransaksi"));
    reservation.setRute(rs.getString("rute"));
    reservation.setKelas(rs.getString("kelas"));
    reservation.setTanggaltf(rs.getDate("tanggaltf").toLocalDate());
    reservation.setIdpesawat(rs.getInt("idpesawat"));
    return reservation;
  }
}
