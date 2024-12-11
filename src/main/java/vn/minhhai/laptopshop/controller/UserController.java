package vn.minhhai.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.minhhai.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String data = userService.handleHello();
        model.addAttribute("data", data);
        return "hello";
    }

    @RequestMapping("admin/user/create")
    public String requestMethodName() {
        return "/admin/user/create";
    }

}
