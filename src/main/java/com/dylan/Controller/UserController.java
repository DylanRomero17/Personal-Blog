package com.dylan.Controller;

import com.dylan.entity.UserEntity;
import com.dylan.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/record")
    public String record(Model model) {
        return "/users/register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute  UserEntity user, BindingResult result) {
        if (result.hasErrors()) {
            // Imprime los errores en consola para depuración
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "/users/register"; // Vuelve al formulario si hay errores
        }
            userService.createUser(user);
            return "redirect:/login";
    }

    @GetMapping(value={"/login", "/"})
    public String loginPage() {
        return "/users/login";
    }
}
