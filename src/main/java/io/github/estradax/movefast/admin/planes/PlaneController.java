package io.github.estradax.movefast.admin.planes;

import io.github.estradax.movefast.planes.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/planes")
public class PlaneController {
  @Autowired
  private PlaneService planeService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("planes", planeService.findAll());
    return "admin/dataPesawat";
  }
}
