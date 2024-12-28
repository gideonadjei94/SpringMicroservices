package com.gideon.ecommerce.customer;

import com.gideon.ecommerce.Requests.CreateCustomerRequest;
import com.gideon.ecommerce.Requests.UpdateCustomerRequest;
import com.gideon.ecommerce.customer.Dtos.CustomerDto;
import com.gideon.ecommerce.customer.Exceptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCustomer(@RequestBody @Valid CreateCustomerRequest request){
        try {
            CustomerDto customer = customerService.createCustomer(request);
            return ResponseEntity
                    .status(CREATED)
                    .body(new ApiResponse("Customer Created successfully", customer));
        } catch (ResourceNotFoundException e) {
           return ResponseEntity
                   .status(NOT_FOUND)
                   .body(new ApiResponse(e.getMessage(), null));
        }
    }


    @PutMapping("/update/customer/{customer-id}")
    public ResponseEntity<ApiResponse> updateCustomer(@RequestBody @Valid UpdateCustomerRequest request, @PathVariable("customer-id") String customerId){
        try {
            CustomerDto customer = customerService.updateCustomer(request, customerId);
            return ResponseEntity
                    .status(OK)
                    .body(new ApiResponse("Customer Details Successfully Updated", customer));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(),null));
        }
    }


    @DeleteMapping("/delete/customer/{customer-id}")
    public ResponseEntity<ApiResponse> deleteCustomer(@PathVariable("customer-id") String customerId){
        try {
            customerService.deleteCustomer(customerId);
            return ResponseEntity.ok(new ApiResponse("Customer Successfully Deleted", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity
                    .status(NOT_FOUND)
                    .body(new ApiResponse(e.getMessage(),null));
        }
    }
}
