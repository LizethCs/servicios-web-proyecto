/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.limcasoft.api.service;

import com.limcasoft.api.model.Customer;
import com.limcasoft.api.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow();
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
public Customer updateCustomer(Customer customer) {
    Customer existingCustomer = customerRepository.findById(customer.getId()).orElseThrow();
    existingCustomer.setName(customer.getName());
    existingCustomer.setLastName(customer.getLastName());
    existingCustomer.setEmail(customer.getEmail());
    existingCustomer.setPhone(customer.getPhone());
    existingCustomer.setAddress(customer.getAddress());
    existingCustomer.setDocumentType(customer.getDocumentType());
    existingCustomer.setDocument(customer.getDocument());
    
    if (customer.getReservations() != null) {
        existingCustomer.getReservations().clear();
        existingCustomer.getReservations().addAll(customer.getReservations());
    }
    
    return customerRepository.save(existingCustomer);
}

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
