package vn.minhhai.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import vn.minhhai.laptopshop.domain.dto.RegisterDTO;

@Controller
public class AuthClientController {

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/login";
    }

    @PostMapping("/auth/register")
    public String registerPost(Model model, @ModelAttribute("registerUser") RegisterDTO registerDTO) {
        System.out.println(registerDTO);
        return "client/auth/login";
    }

}
