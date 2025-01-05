package com.gideon.ecommerce.product;

import com.gideon.ecommerce.product.Exceptions.ResourceNotFoundException;
import com.gideon.ecommerce.product.Models.Category;
import com.gideon.ecommerce.product.Models.Product;
import com.gideon.ecommerce.product.Repository.CategoryRepository;
import com.gideon.ecommerce.product.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;


    public Product createProduct(ProductRequest request) {
        Category category = categoryRepository
                                        .findById(request.categoryId())
                                        .orElseThrow(() -> new ResourceNotFoundException("Category Not Found"));
        Product product = new Product();
        product.setName(request.name());
        product.setDescription(request.description());
        product.setQuantity(request.quantity());
        product.setPrice(request.price());
        product.setCategory(category);
        return repository.save(product);
    }

    public Product findProductById(Integer productId) {
        return repository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Not found"));
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}
