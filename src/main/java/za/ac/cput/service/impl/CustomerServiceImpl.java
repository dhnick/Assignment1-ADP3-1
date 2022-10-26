package za.ac.cput.service.impl;

/* CustomerServiceImpl.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;
import za.ac.cput.service.CustomerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static  CustomerService service ;

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String customerID) {
        return this.customerRepository.findById(customerID)
                .orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (this.customerRepository.existsById(customer.getCustomerID()))
            return this.customerRepository.save(customer);
        return customer;
    }

    @Override
    public boolean delete(String customerID) {
        this.customerRepository.deleteById(customerID);
        if(this.customerRepository.existsById(customerID)){
            System.out.println("Customer: "+customerID+" not Deleted");
            return false;
        }
        else{
            System.out.println("Customer Deleted");
            return true;
        }
    }


    // List of all Employees
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll().stream().collect(Collectors.toList());
    }


}
