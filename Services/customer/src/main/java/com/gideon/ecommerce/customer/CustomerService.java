package com.gideon.ecommerce.customer;


import com.gideon.ecommerce.customer.Dtos.CustomerDto;
import com.gideon.ecommerce.customer.Exceptions.AlreadyExistsException;
import com.gideon.ecommerce.customer.Mappers.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerDto createCustomer(CustomerRequest request) {
        return Optional.of(request)
                .filter(user -> !customerRepository.existsByEmail(request.email()))
                .map(req -> {
                    Customer customer = new Customer();
                    customer.setFirstName(request.firstName());
                    customer.setLastName(request.lastName());
                    customer.setEmail(request.email());
                    customer.setAddress(request.address());
                    Customer savedCustomer = customerRepository.save(customer);
                    return mapper.apply(savedCustomer);
                }).orElseThrow(() -> new AlreadyExistsException("User Already Exists"));

    }
}
