package web.pp_3_1_2.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.pp_3_1_2.model.User;
import web.pp_3_1_2.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", ""})
    public String showAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/add")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "addUser";
    }

    @GetMapping("/{id}/edit")
    public String editUserForm(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getUserById(id);
        if (null == user) {
            return "redirect:/users";
        }
        model.addAttribute("user", user);
        return "editUser";
    }

    @PutMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

}