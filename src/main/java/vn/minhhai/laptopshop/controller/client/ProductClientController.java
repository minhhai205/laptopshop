package vn.minhhai.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.minhhai.laptopshop.domain.Product;
import vn.minhhai.laptopshop.service.ProductService;

@Controller
public class ProductClientController {
    private final ProductService productService;

    public ProductClientController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product")
    public String getProductPage(Model model) {
        List<Product> products = this.productService.getAllProducts();
        model.addAttribute("products", products);
        return "client/product/index";
    }

    @GetMapping("/product/detail")
    public String getProductDetail() {
        return "client/product/detail";
    }

}
