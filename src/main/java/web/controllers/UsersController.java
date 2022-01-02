package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

@Controller
public class UsersController {

    UserService service;

    @Autowired
    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String usersList(Model model) {
        model.addAttribute("userList", service.userList());
        return "users";
    }

    @GetMapping("/add")
    public String addNewUser(Model model) {
        model.addAttribute("newUser", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addNewUser(@ModelAttribute User user, Model model) {
        service.addUser(user);
        model.addAttribute("newUser", user);
        return "redirect:/";
    }

    @PostMapping("/update/{userId}")
    public String updateUser(Model model, @PathVariable("userId") String userId) {
        return "redirect:/";
    }
}
