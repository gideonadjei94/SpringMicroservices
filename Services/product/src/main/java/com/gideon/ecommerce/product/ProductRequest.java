package com.gideon.ecommerce.product;

import com.gideon.ecommerce.product.Models.Category;
import jakarta.validation.constraints.NotBlank;


public record ProductRequest(

        @NotBlank(message = "Product name is required")
        String name,
        String description,

        @NotBlank(message = "Product quantity is required")
        double quantity,

        @NotBlank(message = "Product price is required")
        double price,

        Category category
) {
}
