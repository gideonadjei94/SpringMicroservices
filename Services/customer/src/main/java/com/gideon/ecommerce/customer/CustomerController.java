package com.gideon.ecommerce.customer;

import com.gideon.ecommerce.customer.Dtos.CustomerDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody @Valid CustomerRequest request){
        CustomerDto customer = customerService.createCustomer(request);
        return ResponseEntity.ok(new ApiResponse("Customer Created Successfully", customer));
    }
}
