package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepository;
import ru.kata.spring.boot_security.demo.repositories.UserRepository;
import ru.kata.spring.boot_security.demo.services.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    private UserService userService;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, RoleRepository roleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

//    @GetMapping("/")
//    public String myPage(@ModelAttribute("user")User user) {
//        return "/user/my_page";
//    }

    @GetMapping("/admin")
    public String pageForAuthenticatedUsers(ModelMap modelMap){
        modelMap.addAttribute("users", userService.getAllUsers());
        return "admin/all_users";
    }

    @GetMapping("/admin/new")
    public String getNewPage(@ModelAttribute("user")User user){
        return "/admin/new";
    }

    @PostMapping()
    public String regUser(@ModelAttribute("user")User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/new";
        }
        userService.save(user);
        return "redirect:/admid";
    }

    @GetMapping("/admin/{id}/update")
    public String getUpdatePage(ModelMap modelMap, @PathVariable("id") long id) {
        modelMap.addAttribute("user_update", userService.getUserByid(id));
        return "/admin/update";
    }

    @PutMapping()
    public String updateUser(@ModelAttribute("user") @Valid User user,BindingResult bindingResult,
                             @PathVariable("id") long id) {
    if (bindingResult.hasErrors()) {
        return "/admin/update";
    }
    userService.update(user, id);
    return "redirect:/admin";
    }

}
