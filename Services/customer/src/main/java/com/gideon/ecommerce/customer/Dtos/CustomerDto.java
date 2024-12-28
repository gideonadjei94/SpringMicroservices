package com.gideon.ecommerce.customer.Dtos;

import com.gideon.ecommerce.customer.Models.Address;


public record CustomerDto(
        String firstName,
        String lastName,
        String email,
        Address address
) {

}
