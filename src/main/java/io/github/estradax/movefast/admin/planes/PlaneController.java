package io.github.estradax.movefast.admin.planes;

import io.github.estradax.movefast.planes.Plane;
import io.github.estradax.movefast.planes.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("{id}/edit")
  public String edit(@PathVariable String id, Model model) {
    Plane plane = planeService.findById(Integer.parseInt(id));

    PlaneUpdateForm planeUpdateForm = new PlaneUpdateForm();
    planeUpdateForm.setNamaMaskapai(plane.getNama_maskapai());
    planeUpdateForm.setJenisPesawat(plane.getJenis_pesawat());

    model.addAttribute("planeForm", planeUpdateForm);
    model.addAttribute("plane", plane);
    return "admin/UpdatedataPesawat";
  }

  @PostMapping("/{id}/edit")
  public String update(@PathVariable String id, @ModelAttribute PlaneUpdateForm planeUpdateForm) {
    planeService.update(Integer.parseInt(id), planeUpdateForm);

    return "redirect:/admin/planes";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable String id) {
    planeService.delete(Integer.parseInt(id));
    return "redirect:/admin/planes";
  }
}
