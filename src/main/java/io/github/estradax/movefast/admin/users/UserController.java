package io.github.estradax.movefast.admin.users;

import io.github.estradax.movefast.penumpang.PenumpangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/users")
public class UserController {
  @Autowired
  private PenumpangService penumpangService;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("users", penumpangService.findAll());
    return "admin/dataUser";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable String id) {
    penumpangService.delete(Integer.parseInt(id));
    return "redirect:/admin/users";
  }
}
