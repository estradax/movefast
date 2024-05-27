package io.github.estradax.movefast.flights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/flights")
public class FlightController {
  @Autowired
  private FlightService flightService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("flights", flightService.findAll());
    return "daftar_penerbangan";
  }
}
