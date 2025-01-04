package com.gideon.ecommerce.product;

public record ApiResponse(
        String message,
        Object data
) {
}
