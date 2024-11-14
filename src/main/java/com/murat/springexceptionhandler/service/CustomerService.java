package com.murat.springexceptionhandler.service;

import com.murat.springexceptionhandler.entity.Customer;
import com.murat.springexceptionhandler.exception.CustomerNotFoundException;
import com.murat.springexceptionhandler.exception.CustomerNotNullException;
import com.murat.springexceptionhandler.repositroy.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        if (customer.getName().isBlank() || customer.getName().isEmpty()) {
            throw new CustomerNotNullException("Customer name must be not null");
        }
        return customerRepository.save(customer);

    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        Customer customer = optionalCustomer.orElseThrow(() -> new CustomerNotFoundException(customerId + " "));
        return customer;
    }

    public void deleteCustomerById(Long customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        optionalCustomer.orElseThrow(() -> new CustomerNotFoundException(customerId.toString()));

        customerRepository.deleteById(customerId);
    }

}
