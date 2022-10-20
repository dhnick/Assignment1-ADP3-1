package za.ac.cput.controller;

/*
Damone Hartnick 219093717
CustomerController.java
Date : August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerServiceImpl;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/customer/")
@Slf4j
public class CustomerController {

    @Autowired
    private final CustomerServiceImpl customerService;


    @Autowired
    public CustomerController(CustomerServiceImpl customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        Customer saveCustomer = CustomerFactory.createCustomer(
                customer.getCustomerID()
                ,customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getAddress(),customer.getContactNumber());
        return customerService.save(saveCustomer);
    }

    @RequestMapping("/read/{customerID}")
    public Optional<Customer> read(@PathVariable String customerID){
        return customerService.read(customerID);
    }


    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer)
    {return customerService.update(customer);}


    @DeleteMapping("/delete/{customerID}")
    public boolean delete(@PathVariable String customerID) {
        return customerService.delete(customerID);}


    @GetMapping("/findAll")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

}
