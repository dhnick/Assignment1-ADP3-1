package za.ac.cput.controller;

/*
Damone Hartnick 219093717
CustomerController.java
Date : August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.impl.CustomerServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("restaurant/customer/")  // or just /customer
@Slf4j

public class CustomerController {

    private final CustomerServiceImpl customerService;


    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer) {
        return ResponseEntity.ok
                (this.customerService.save(customer));
    }

    @GetMapping("read/{type}")
    public ResponseEntity<Customer> read(@PathVariable String customerID) {
        Customer read = this.customerService.findByCustomerId(customerID);
        return ResponseEntity.ok(read);
    }

    @DeleteMapping("delete/{type}")
    public ResponseEntity<Void> deleteCustomerByCustomerID(@PathVariable String customerID)
    {
        this.customerService.deleteCustomerByCustomerID(customerID);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("all")
    public ResponseEntity<List<Customer>> findAll() {
        List<Customer> customers = this.customerService.findAll();
        return ResponseEntity.ok(customers);
    }



}
