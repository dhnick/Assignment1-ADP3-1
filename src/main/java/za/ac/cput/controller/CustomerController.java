package za.ac.cput.controller;

/*
Damone Hartnick 219093717
CustomerController.java
Date : August 2022
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Customer;
import za.ac.cput.service.CustomerService;
import za.ac.cput.service.ICustomerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("restaurant/customer/")
@Slf4j

public class CustomerController {


    private final ICustomerService iCustomerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.iCustomerService = customerService;
    }


    @PostMapping("save")
    public ResponseEntity<Customer> save(@Valid @RequestBody Customer customer){
        log.info("Save request: {}", customer);
        Customer saved = iCustomerService.save(customer);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("read/{customerID}")
    public ResponseEntity<Customer> read(@PathVariable String customerID){
        Customer customer = this.iCustomerService.read(customerID)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("delete/{customerID}")
    public ResponseEntity<Void> delete(@PathVariable String id)
    {
        log.info("Delete request: {}", id);
        this.iCustomerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("findAll")
    public ResponseEntity<List<Customer>> findAll(){
        List<Customer> customerList = this.iCustomerService.findAll();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("findByCustomerId")
    public ResponseEntity<List<Customer>> findByStaffId(@PathVariable String customerID){
        log.info(" Find request: {}" , customerID);
        List<Customer> customerList = this.iCustomerService.findByCustomerId(customerID);
        return ResponseEntity.ok(customerList);

    }

    @GetMapping("findCustomerFirstNameByEmail")
    public ResponseEntity<Optional<Customer>> findCustomerFirstNameByEmail(@PathVariable String email) {
        log.info(" Find request : {}" , email );
        Optional<Customer> customerOptional = this.iCustomerService.findCustomerFirstNameByEmail(email);
        return ResponseEntity.ok(customerOptional);

    }


}
