package com.ecomm.product;

import com.ecomm.product.Models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<ApiResponse> createProduct(@RequestBody CreateProductRequest request){
        Product product = productService.createProduct(request);
        return ResponseEntity
                .status(CREATED)
                .body(new ApiResponse("Product Created Successfully", product));
    }


    @GetMapping("/product/{product-id")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("product-id") Integer productId){
        Product product = productService.getProductById(productId);
        return ResponseEntity.ok(new ApiResponse("Product Fetched ", product));
    }


    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Products Fetched", products));
    }
}
