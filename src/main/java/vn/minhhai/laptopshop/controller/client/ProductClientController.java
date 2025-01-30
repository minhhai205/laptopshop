package vn.minhhai.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductClientController {
    @GetMapping("/product")
    public String getProductPage() {
        return "client/product/index";
    }

    @GetMapping("/product/detail")
    public String getProductDetail() {
        return "client/product/detail";
    }

}
