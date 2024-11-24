package com.limcasoft.api.controller;

import com.limcasoft.api.model.Customer;
import com.limcasoft.api.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private boolean validateCredentials(@RequestHeader("Authorization") String authorization) {
        String[] credentials = authorization.split(" ");
        return credentials[0].equals("Basic") && credentials[1].equals("dXNlcjpwYXNzd29yZA==");
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(customerService.getAllCustomers());
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(customerService.getCustomerById(id));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(customerService.createCustomer(customer));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            return ResponseEntity.ok(customerService.updateCustomer(customer));
        } else {
            return ResponseEntity.status(401).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id, @RequestHeader("Authorization") String authorization) {
        if (validateCredentials(authorization)) {
            customerService.deleteCustomer(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(401).build();
        }
    }
}
