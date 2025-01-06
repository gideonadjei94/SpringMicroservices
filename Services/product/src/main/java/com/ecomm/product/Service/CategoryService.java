package com.ecomm.product.Service;

import com.ecomm.product.Exceptions.AlreadyExistsException;
import com.ecomm.product.Exceptions.ResourceNotFoundException;
import com.ecomm.product.Models.Category;
import com.ecomm.product.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;


    public Category createCategory(String name) {
        return Optional.of(name)
                .filter(category -> !repository.existsByName(name))
                .map(c -> {
                    Category category = new Category();
                    category.setName(name);
                    return repository.save(category);
                }).orElseThrow(() -> new AlreadyExistsException("Category Already Exists"));
    }

    public Category getCategoryByName(String name) {
        try {
            return repository.findByName(name);
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Category Not Found");
        }
    }

    public List<Category> getCategories() {
        return repository.findAll();
    }
}
