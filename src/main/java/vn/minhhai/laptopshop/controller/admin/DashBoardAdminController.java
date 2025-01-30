package vn.minhhai.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardAdminController {
    @GetMapping("/admin")
    public String getDashBoard() {
        return "admin/dashboard/index";
    }
}
