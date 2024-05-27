package io.github.estradax.movefast.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public List<Flight> findAll() {
    String sql = "select jadwal_penerbangan.waktuberangkat, jadwal_penerbangan.waktutiba, pesawat.nama_maskapai, pesawat.jenis_pesawat from jadwal_penerbangan inner join pesawat on jadwal_penerbangan.idpesawat = pesawat.idpesawat";
    List<Flight> flights = jdbcTemplate.query(sql, new FlightMapper());

    System.out.println(flights.size());

    return flights;
  }
}
