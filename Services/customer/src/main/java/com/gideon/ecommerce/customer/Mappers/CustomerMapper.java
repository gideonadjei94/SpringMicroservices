package com.gideon.ecommerce.customer.Mappers;
import com.gideon.ecommerce.customer.Customer;
import com.gideon.ecommerce.customer.Dtos.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CustomerMapper implements Function<Customer, CustomerDto> {
    @Override
    public CustomerDto apply(Customer customer){
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
