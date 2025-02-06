package vn.minhhai.laptopshop.controller.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.dto.RegisterDTO;
import vn.minhhai.laptopshop.mapper.UserMapper;
import vn.minhhai.laptopshop.service.UserService;

@Controller
public class AuthClientController {
    private final UserMapper userMapper;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public AuthClientController(UserMapper userMapper, UserService userService,
            PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/auth/login")
    public String login(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/login";
    }

    @PostMapping("/auth/register")
    public String registerPost(Model model,
            @ModelAttribute("registerUser") @Valid RegisterDTO registerDTO,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "client/auth/login";
        }

        User user = this.userMapper.registerDTOtoUser(registerDTO);
        String hashPassword = this.passwordEncoder.encode(user.getPassword());

        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName("USER"));

        this.userService.handleSaveUser(user);

        return "redirect:/auth/login";
    }

}
