package ru.javamentors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.javamentors.entity.AppUser;
import ru.javamentors.entity.Role;
import ru.javamentors.repository.UserRepository;
import ru.javamentors.service.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userlist")
    public String userList(@ModelAttribute("edit") String edit, @ModelAttribute("user") AppUser appUser, Model model){
        if (! edit.equals("")){
            AppUser getAppUser = userService.getUserById(appUser.getId());
            model.addAttribute("userEdit", getAppUser);
        }
        List<AppUser> appUsers = userService.getUsers();
        model.addAttribute("users", appUsers);
        return "userList";
    }



    @PostMapping("/add")
    public String add(@ModelAttribute("user") AppUser appUser, @RequestParam("name") String name,
                      @RequestParam("password") String password){
        AppUser newAppUser = new AppUser(name, password);
        userService.addUser(newAppUser);
        return "redirect:/userlist";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") AppUser appUser, @RequestParam("name") String name,
                       @RequestParam("password") String password){
        AppUser oldUser = userService.getUserById(appUser.getId());
        AppUser editAppUser = new AppUser(appUser.getId(), name, password);
        for (Role role : oldUser.getRoles()) {
            editAppUser.setRoles(role);
        }
        userService.editUser(editAppUser);
        return "redirect:/userlist";
    }
    @Transactional
    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") AppUser appUser){
        AppUser getAppUser = userService.getUserById(appUser.getId());
        for (Role role: getAppUser.getRoles())
            role.getAppUsers().remove(getAppUser);
        userService.deleteUser(getAppUser);
        return "redirect:/userlist";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") AppUser appUser){
        userService.addUser(appUser);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") AppUser appUser, RedirectAttributes redirectAttributes){
        AppUser loginedAppUser = userService.getUser(appUser.getName());
        redirectAttributes.addFlashAttribute("user", loginedAppUser);
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String hello(Principal principal, Model model){
        AppUser appUser = (AppUser) userService.getUser(principal.getName());
        model.addAttribute("user", appUser);
        return "hello";
    }

    @GetMapping("/access_denied")
    public String accessDenied(){
        return "accessDenied";
    }
}
