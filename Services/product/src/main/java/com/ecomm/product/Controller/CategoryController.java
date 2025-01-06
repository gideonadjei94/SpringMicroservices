package com.ecomm.product.Controller;

import com.ecomm.product.ApiResponse;
import com.ecomm.product.Models.Category;
import com.ecomm.product.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody String name){
        Category category = service.createCategory(name);
        return ResponseEntity
                .status(CREATED)
                .body(new ApiResponse("Category Successfully Created", category));
    }

    @GetMapping("/{category-name}")
    public ResponseEntity<ApiResponse> getCategory(@PathVariable("category-name") String name){
        Category category = service.getCategoryByName(name);
        return ResponseEntity.ok(new ApiResponse("Category Fetched", category));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getCategories(){
        List<Category> categories = service.getCategories();
        return ResponseEntity.ok(new ApiResponse("Category Fetched", categories));
    }
}
