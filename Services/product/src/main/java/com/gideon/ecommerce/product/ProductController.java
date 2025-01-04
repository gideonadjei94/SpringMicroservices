package com.gideon.ecommerce.product;

import com.gideon.ecommerce.product.Models.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService service;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody @Valid ProductRequest request){
        service.createProduct(request);
        return ResponseEntity
                .status(CREATED)
                .body(new ApiResponse("Product Successfully Added", null));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = service.getProducts();
        return ResponseEntity.ok(new ApiResponse("Products Fetched Successfully", products));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("product-id") Integer productId){
        Product product = service.findProductById(productId);
        return ResponseEntity.ok(new ApiResponse("Product Fetched Successfully", product));
    }
}
