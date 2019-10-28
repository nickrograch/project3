package ru.javamentors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.javamentors.entity.AppUser;
import ru.javamentors.entity.Role;
import ru.javamentors.service.UserService;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") AppUser appUser){
        Role role = new Role();
        role.setId(2L);
        role.setRole("USER");
        appUser.getRoles().add(role);
        userService.addUser(appUser);
        return "redirect:/login";
    }
}
