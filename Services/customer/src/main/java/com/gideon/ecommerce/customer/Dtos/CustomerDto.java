package com.gideon.ecommerce.customer.Dtos;

import com.gideon.ecommerce.customer.Address;
import lombok.Data;


public record CustomerDto(
        String firstName,
        String lastName,
        String email,
        Address address
) {

}
