package ru.neshin.posta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.neshin.posta.service.UserService;

@Controller
@Secured({"ADMIN"})
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping("/admin/users")
    ModelAndView index(Model model) {
        ModelAndView modelAndView = new ModelAndView("admin/users");
        modelAndView.addObject("users", userService.getAllUsers());
        return modelAndView;
    }

}
