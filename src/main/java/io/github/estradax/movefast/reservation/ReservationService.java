package io.github.estradax.movefast.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  public Reservation findById(Integer id) {
    String sql = "SELECT * FROM transaksi_tiket WHERE idtransaksi = ?";

    List<Reservation> reservations = jdbcTemplate.query(sql, new ReservationMapper(), id);

    if (reservations.size() == 1) {
      return reservations.get(0);
    }
    return null;
  }

  public Integer create(ReservationForm reservationForm) {
    String sql = "INSERT INTO transaksi_tiket(rute, kelas, harga, tanggaltf) VALUES (?, ?, ?, ?)";

    String route = String.format("%s - %s", reservationForm.getDepartureCity(), reservationForm.getDestinationCity());

    int count = jdbcTemplate.update(sql, route, reservationForm.getType(), 1000, LocalDate.now());

    String getLastIdSql = "SELECT MAX(idtransaksi) FROM transaksi_tiket";
    Integer lastId = jdbcTemplate.queryForObject(getLastIdSql, Integer.class);

    return lastId;
  }
}
