package com.ecomm.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequest(

        @NotBlank(message = "Product Name is Required")
        String name,

        String description,

        @NotNull(message = "Product's Available Quantity is required")
        @Positive(message = "Product Quantity should be positive")
        Integer quantity,

        @NotNull(message = "Product's Price is required")
        @Positive(message = "Product price should be positive")
        BigDecimal price,

        @NotBlank(message = "Product's Category is required")
        String categoryName
) {
}
