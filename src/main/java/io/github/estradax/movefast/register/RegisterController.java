package io.github.estradax.movefast.register;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
  Logger logger = LoggerFactory.getLogger(RegisterController.class);

  @Autowired
  private RegisterService registerService;

  @GetMapping("")
  public String view(Model model) {
    model.addAttribute("registerForm", new RegisterForm());
    return "register";
  }

  @PostMapping("")
  public String post(@Valid @ModelAttribute RegisterForm registerForm, BindingResult bindingResult, HttpServletRequest request) throws ServletException {
    if (bindingResult.hasErrors()) {
      return "register";
    }

    boolean isSuccess = registerService.register(registerForm);

    if (!isSuccess) {
      bindingResult.rejectValue("email", "error.email", "email already exists");
      return "register";
    }

    logger.info("successfully registered new user - email={}", registerForm.getEmail());

    request.login(registerForm.getEmail(), registerForm.getPassword());

    return "redirect:/";
  }
}
