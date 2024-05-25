package io.github.estradax.movefast.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ReservationService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public boolean create(ReservationForm reservationForm) {
    String sql = "INSERT INTO transaksi_tiket(rute, kelas, harga, tanggaltf) VALUES (?, ?, ?, ?)";

    String route = String.format("%s - %s", reservationForm.getDepartureCity(), reservationForm.getDestinationCity());

    int count = jdbcTemplate.update(sql, route, reservationForm.getType(), 1000, LocalDate.now());
    return count == 1;
  }
}
