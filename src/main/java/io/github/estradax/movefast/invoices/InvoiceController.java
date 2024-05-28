package io.github.estradax.movefast.invoices;

import io.github.estradax.movefast.reservation.Reservation;
import io.github.estradax.movefast.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
  @Autowired
  private ReservationService reservationService;

  @GetMapping("")
  public String index(@RequestParam("invoice_id") Integer invoiceId, Model model) {
    Reservation reservation = reservationService.findById(invoiceId);
    model.addAttribute("reservation", reservation);
    return "invoice";
  }
}
