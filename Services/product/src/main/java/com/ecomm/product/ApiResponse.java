package com.ecomm.product;

public record ApiResponse(
        String message,
        Object data
) {
}
