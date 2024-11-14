package com.murat.springexceptionhandler.controller;



import com.murat.springexceptionhandler.entity.Customer;
import com.murat.springexceptionhandler.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer addCustomer = customerService.addCustomer(customer);
        return  new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customerService.findAllCustomer();
        return new ResponseEntity<List<Customer>>(allCustomer,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerId(@PathVariable("id") Long id){
        Customer customerById = customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(customerById,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
