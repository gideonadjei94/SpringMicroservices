package com.gideon.ecommerce.product;

import com.gideon.ecommerce.product.Models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;


    public void createProduct(ProductRequest request) {
    }

    public Product findProductById(Integer productId) {
        return null;
    }

    public List<Product> getProducts() {
        return null;
    }
}
