package com.ecomm.product.Controller;

import com.ecomm.product.ApiResponse;
import com.ecomm.product.Models.Product;
import com.ecomm.product.ProductRequest;
import com.ecomm.product.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody ProductRequest request){
        Product product = productService.createProduct(request);
        return ResponseEntity
                .status(CREATED)
                .body(new ApiResponse("Product Created Successfully", product));
    }


    @PutMapping("/update/{product-id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("product-id") Integer productId ,@Valid @RequestBody ProductRequest request){
        Product product = productService.updateProduct(productId, request);
        return ResponseEntity.ok(new ApiResponse("Product Successfully Updated", product));
    }

    @GetMapping("/product/{product-id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("product-id") Integer productId){
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(new ApiResponse("Product Fetched ", product));
    }


    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Products Fetched", products));
    }


    @DeleteMapping("/delete/{product-id}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("product-id") Integer productId){
        productService.deleteProduct(productId);
        return ResponseEntity.ok(new ApiResponse("Product Deleted Successfully", null));
    }
}
