package com.ecomm.product;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        String description,
        Integer quantity,
        BigDecimal price,
        Integer categoryId
) {
}
