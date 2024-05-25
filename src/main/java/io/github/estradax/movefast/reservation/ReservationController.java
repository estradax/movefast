package io.github.estradax.movefast.reservation;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
  @Autowired
  private ReservationService reservationService;

  @GetMapping("")
  public String view(Model model) {
    model.addAttribute("reservationForm", new ReservationForm());
    return "transaksi";
  }

  @PostMapping("")
  public String post(@Valid  @ModelAttribute ReservationForm reservationForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "transaksi";
    }

    if (!reservationService.create(reservationForm)) {
      bindingResult.rejectValue("departureCity", "error.departureCity", "something bad happened, try again");
      return "transaksi";
    }

    return "redirect:/";
  }
}
