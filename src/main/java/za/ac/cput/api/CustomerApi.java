package za.ac.cput.api;

/*
Damone Hartnick
CustomerApi.java
Student Number 219093717
Date : August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.impl.CustomerServiceImpl;


@Component
public class CustomerApi {

    public final CustomerServiceImpl customerService;

    @Autowired
    public CustomerApi ( CustomerServiceImpl customerService){
        this.customerService = customerService;
    }


    public Customer save (Customer customer){
        this.customerService.read(customer.getCustomerID())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID not found"));
        return this.customerService.save(customer);
    }


    // links to customer controller
    //public Customer getByCustomerID (String customerID){
     // Customer = this.customerService.findByCustomerId(customerID);
     // if (.isEmpty())
        //  return null;
    //  else
          //return list.get(0);

    }


