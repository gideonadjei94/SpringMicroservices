package com.ecomm.product;

import com.ecomm.product.Exceptions.ResourceNotFoundException;
import com.ecomm.product.Models.Category;
import com.ecomm.product.Models.Product;
import com.ecomm.product.Repository.CategoryRepository;
import com.ecomm.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(CreateProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(() -> new ResourceNotFoundException("Product's Category Not Found"));
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setQuantity(request.quantity());
        product.setPrice(request.price());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product getProductById(Integer productId) {
        return productRepository
                .findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
