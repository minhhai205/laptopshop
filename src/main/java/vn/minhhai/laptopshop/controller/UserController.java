package vn.minhhai.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        String data = userService.handleHello();
        model.addAttribute("data", data);
        return "hello";
    }

    @RequestMapping("/admin/user/create")
    public String create(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createPost(Model model, @ModelAttribute("newUser") User user) {
        System.out.println("run here" + user);
        this.userService.handleSaveUser(user);
        return "hello";
    }

}
