package vn.minhhai.laptopshop.controller.admin;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.service.UploadService;
import vn.minhhai.laptopshop.service.UserService;

@Controller
public class UserAdminController {
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserAdminController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/admin/user")
    public String getUser(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/user/index";
    }

    @GetMapping("/admin/user/create")
    public String create(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createPost(Model model, @RequestParam("fileInput") MultipartFile file,
            @ModelAttribute("newUser") User user) {

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassword());

        user.setAvatar(avatar);
        user.setPassword(hashPassword);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));

        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/detail/{id}")
    public String detail(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/detail";
    }

    @GetMapping("/admin/user/update/{id}")
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
