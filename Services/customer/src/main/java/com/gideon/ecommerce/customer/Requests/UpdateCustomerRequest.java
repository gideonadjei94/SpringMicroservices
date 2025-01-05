package com.gideon.ecommerce.customer.Requests;

import com.gideon.ecommerce.customer.Models.Address;

public record UpdateCustomerRequest(
        String firstname,
        String lastname,
        Address address
) {
}
