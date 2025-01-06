package com.ecomm.product.Service;

import com.ecomm.product.Exceptions.ResourceNotFoundException;
import com.ecomm.product.Models.Category;
import com.ecomm.product.Models.Product;
import com.ecomm.product.ProductRequest;
import com.ecomm.product.Repository.CategoryRepository;
import com.ecomm.product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService{

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public Product createProduct(ProductRequest request) {
        Category category = Optional.ofNullable(categoryRepository.findByName(request.categoryName()))
                .orElseGet(() -> {
                    Category newCategory = new Category(request.categoryName());
                    return categoryRepository.save(newCategory);
                });
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


    public void deleteProduct(Integer productId) {
        productRepository
                .findById(productId)
                .ifPresentOrElse(
                        productRepository::delete,
                        () -> new ResourceNotFoundException("Product Not Found")
                );
    }


    public Product updateProduct(Integer productId, ProductRequest request) {
         Product product = productRepository.findById(productId)
                 .orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
             product.setName(request.name());
             product.setDescription(request.description());
         product.setQuantity(request.quantity());
         product.setPrice(request.price());
         return productRepository.save(product);
    }
}
