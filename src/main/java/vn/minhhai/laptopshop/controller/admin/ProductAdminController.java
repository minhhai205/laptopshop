package vn.minhhai.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductAdminController {
    @GetMapping("/admin/product")
    public String getProductPage() {
        return "admin/product/index";
    }
}
