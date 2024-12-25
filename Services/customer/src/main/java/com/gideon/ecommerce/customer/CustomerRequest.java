package com.gideon.ecommerce.customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record CustomerRequest(

        @NotNull(message = "Customer firstname is required")
        String firstName,

        @NotNull(message = "Customer lastname is required")
        String lastName,

        @Email(message = "Customer Email is not valid")
        @NotNull(message = "Customer email is required")
        String email,

        Address address
) {
}
