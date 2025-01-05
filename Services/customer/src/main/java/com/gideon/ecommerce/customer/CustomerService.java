package com.gideon.ecommerce.customer;


import com.gideon.ecommerce.customer.Requests.CreateCustomerRequest;
import com.gideon.ecommerce.customer.Requests.UpdateCustomerRequest;
import com.gideon.ecommerce.customer.Dtos.CustomerDto;
import com.gideon.ecommerce.customer.Exceptions.AlreadyExistsException;
import com.gideon.ecommerce.customer.Exceptions.ResourceNotFoundException;
import com.gideon.ecommerce.customer.Mappers.CustomerMapper;
import com.gideon.ecommerce.customer.Models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    public CustomerDto createCustomer(CreateCustomerRequest request) {
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

    public  CustomerDto updateCustomer(UpdateCustomerRequest request, String customerId){
        return customerRepository.findById(customerId)
                .map(customer -> {
                    customer.setFirstName(request.firstname());
                    customer.setLastName(request.lastname());
                    customer.setAddress(request.address());
                    Customer savedCustomer = customerRepository.save(customer);
                    return mapper.apply(savedCustomer);
                }).orElseThrow(() -> new ResourceNotFoundException("Customer Not Found"));
    }

    public void deleteCustomer(String customerId){
        customerRepository.findById(customerId)
                .ifPresentOrElse(customerRepository::delete, () -> {
                    throw new ResourceNotFoundException("Customer Not Found");
                });
    }
}
