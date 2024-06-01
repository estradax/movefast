package io.github.estradax.movefast.admin.users;

import io.github.estradax.movefast.penumpang.Penumpang;
import io.github.estradax.movefast.penumpang.PenumpangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @GetMapping("/{id}/edit")
  public String edit(@PathVariable String id, Model model) {
    Penumpang penumpang = penumpangService.findById(Integer.parseInt(id));

    UserUpdateForm userUpdateForm = new UserUpdateForm();
    userUpdateForm.setNama(penumpang.getNama());
    userUpdateForm.setEmail(penumpang.getEmail());
    userUpdateForm.setAddress(penumpang.getAlamat());
    userUpdateForm.setPhoneNumber(penumpang.getNotlfn());;

    model.addAttribute("userForm", userUpdateForm);
    model.addAttribute("user", penumpang);
    return "admin/update-user";
  }

  @PostMapping("/{id}/edit")
  public String update(@PathVariable String id, @ModelAttribute UserUpdateForm userUpdateForm) {
    penumpangService.update(Integer.parseInt(id), userUpdateForm);

    return "redirect:/admin/users";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable String id) {
    penumpangService.delete(Integer.parseInt(id));
    return "redirect:/admin/users";
  }
}
