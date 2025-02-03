package vn.minhhai.laptopshop.service;

import org.springframework.stereotype.Service;
import vn.minhhai.laptopshop.domain.Product;
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
}
