package za.ac.cput.api;

/*
Damone Hartnick 219093717
CustomerApi.java
Date : August 2022
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.ICustomerService;



@Component
public class CustomerApi {

    public final ICustomerService customerService;


    @Autowired
    public CustomerApi ( ICustomerService customerService){
        this.customerService = customerService;
    }

    public Customer save ( Customer customer) {
        try {
            if (customerService.findByCustomerId(customer.getCustomerID()) != null)
            {
                return customerService.create(customer);
            }

            else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer ID not found , please create customer first");
            }

        } catch ( IllegalArgumentException ex ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer ID not found , Please create customer first");
              }

        }
    }

