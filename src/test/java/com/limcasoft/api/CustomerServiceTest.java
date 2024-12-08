package com.limcasoft.api;

import com.limcasoft.api.model.Customer;
import com.limcasoft.api.repository.CustomerRepository;
import com.limcasoft.api.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private Customer customer;

    @Before
    public void setUp() {
        customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("john.doe@example.com");
    }

    @Test
    public void testGetAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(customer);
        when(customerRepository.findAll()).thenReturn(customers);
        List<Customer> result = customerService.getAllCustomers();
        assertNotNull(result);
        assertEquals(1, result.size());
    }

    @Test
    public void testGetCustomerById() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));
        Customer result = customerService.getCustomerById(1L);
        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    public void testCreateCustomer() {
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer result = customerService.createCustomer(customer);
        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    public void testUpdateCustomer() {
        when(customerRepository.findById(1L)).thenReturn(java.util.Optional.of(customer));
        customer.setName("Jane Doe");
        Customer result = customerService.updateCustomer(customer);
        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    public void testDeleteCustomer() {
        customerService.deleteCustomer(1L);
        
    }
}