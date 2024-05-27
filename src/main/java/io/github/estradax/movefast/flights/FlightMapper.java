package io.github.estradax.movefast.flights;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightMapper implements RowMapper<Flight> {
  @Override
  public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
    Flight flight = new Flight();
    flight.setWaktuberangkat(rs.getTimestamp("waktuberangkat"));
    flight.setWaktutiba(rs.getTimestamp("waktutiba"));
    flight.setNama_maskapai(rs.getString("nama_maskapai"));
    flight.setJenis_pesawat(rs.getString("jenis_pesawat"));
    return flight;
  }
}
