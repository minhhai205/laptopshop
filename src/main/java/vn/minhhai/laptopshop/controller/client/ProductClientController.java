package vn.minhhai.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping("/product/detail/{id}")
    public String getProductDetail(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

    @GetMapping("/auth/login")
    public String login(Model model) {

        return "client/auth/login";
    }

}
