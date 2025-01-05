package com.gideon.ecommerce.product;

import com.gideon.ecommerce.product.Models.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;


@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @Autowired
   private  ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@Valid @RequestBody ProductRequest request){
        Product product = productService.createProduct(request);
        return ResponseEntity
                .status(CREATED)
                .body(new ApiResponse("Product Successfully Added", product));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(new ApiResponse("Products Fetched Successfully", products));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable("product-id") Integer productId){
        Product product = productService.findProductById(productId);
        return ResponseEntity.ok(new ApiResponse("Product Fetched Successfully", product));
    }
}
