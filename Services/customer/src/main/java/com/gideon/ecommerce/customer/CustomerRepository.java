package com.gideon.ecommerce.customer;

import com.gideon.ecommerce.customer.Models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
    boolean existsByEmail(String email);
}
