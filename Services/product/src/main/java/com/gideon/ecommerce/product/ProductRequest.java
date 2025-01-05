package com.gideon.ecommerce.product;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;


public record ProductRequest(

        @NotBlank(message = "Product Name is required")
        String name,

        String description,

        @NotBlank(message = "Product quantity is required")
        @Positive(message = "Product quantity should be positive")
        double quantity,

        @NotBlank(message = "Product Price is required")
        @Positive(message = "Product Price should be Positive")
        BigDecimal price,

        @NotBlank(message = "Product Category is required")
        Integer categoryId
) {
}
