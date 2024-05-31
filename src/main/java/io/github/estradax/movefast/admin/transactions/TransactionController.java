package io.github.estradax.movefast.admin.transactions;

import io.github.estradax.movefast.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/transactions")
public class TransactionController {
  @Autowired
  private ReservationService reservationService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("transactions", reservationService.findAll());
    return "admin/dataTransaksi";
  }
}
