package com.limcasoft.api.controller;

import com.limcasoft.api.model.Customer;
import com.limcasoft.api.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  
  @Autowired
  private CustomerService customerService;
  
  @GetMapping
  public List<Customer> getAllCustomers() {
    return customerService.getAllCustomers();
  }
  
  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }
  
  @PostMapping
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.createCustomer(customer);
  }
  
  @PutMapping("/{id}")
  public Customer updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
    return customerService.updateCustomer(customer);
  }
  
  @DeleteMapping("/{id}")
  public void deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
  }
}