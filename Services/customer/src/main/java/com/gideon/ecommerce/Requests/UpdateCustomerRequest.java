package com.gideon.ecommerce.Requests;

import com.gideon.ecommerce.customer.Models.Address;

public record UpdateCustomerRequest(
        String firstname,
        String lastname,
        Address address
) {
}
