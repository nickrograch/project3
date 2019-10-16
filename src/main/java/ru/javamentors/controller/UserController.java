package ru.javamentors.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.javamentors.entity.User;
import ru.javamentors.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
//@SessionAttributes("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/userlist")
    public String userList(@ModelAttribute("edit") String edit, @ModelAttribute("user") User user, Model model){
        if (! edit.equals("")){
            User getUser = userService.getUserById(user.getId());
            model.addAttribute("userEdit", getUser);
        }
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "userList";
    }



    @PostMapping("/add")
    public String add(@ModelAttribute("user") User user, @RequestParam("name") String name,
                      @RequestParam("password") String password, @RequestParam("role") String role){
        User newUser = new User(name, password, role);
        userService.addUser(newUser);
        return "redirect:/userlist";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("user") User user, @RequestParam("name") String name,
                       @RequestParam("password") String password, @RequestParam("role") String role){
        User editUser = new User(user.getId(), name, password, role);
        userService.editUser(editUser);
        return "redirect:/userlist";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute("user") User user){
        User getUser = userService.getUserById(user.getId());
        userService.deleteUser(getUser);
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
    public String register(@ModelAttribute("user") User user){
        user.setRole("user");
        userService.addUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes){
        User loginedUser = userService.getUser(user.getName());
        redirectAttributes.addFlashAttribute("user", loginedUser);
        return "redirect:/hello";
    }

    @GetMapping("/hello")
    public String hello(@ModelAttribute("user") User user, ModelMap model, HttpSession httpSession){
        model.get("user");
        httpSession.setAttribute("user", user);
        return "hello";
    }
}
