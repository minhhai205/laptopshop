package vn.minhhai.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> listUsers = this.userService.getAllUsers();
        List<User> listUsersByEmail = this.userService.getAllUsersByEmail("haiboss2005@gmail.com");
        System.out.println(listUsers);
        System.out.println(listUsersByEmail);
        model.addAttribute("data", "data from controller");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUser(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/index";
    }

    @RequestMapping("/admin/user/create")
    public String create(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createPost(Model model, @ModelAttribute("newUser") User user) {
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String update(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update/{id}")
    public String updatePost(Model model, @ModelAttribute("newUser") User newUser, @PathVariable Long id) {
        User currentUser = this.userService.getUserById(id);

        if (currentUser != null) {
            currentUser.setFullName(newUser.getFullName());
            currentUser.setPhone(newUser.getPhone());
            currentUser.setAddress(newUser.getAddress());

            this.userService.handleSaveUser(currentUser);
        }

        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String deletePost(Model model, @PathVariable Long id) {
        this.userService.deleteUserById(id);
        return "redirect:/admin/user";
    }

}
