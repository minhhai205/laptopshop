package vn.minhhai.laptopshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import vn.minhhai.laptopshop.domain.Product;
import vn.minhhai.laptopshop.domain.User;
import vn.minhhai.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    public Product getProductById(long id) {
        Optional<Product> result = this.productRepository.findById(id);
        return result.orElse(null);
    }
}
