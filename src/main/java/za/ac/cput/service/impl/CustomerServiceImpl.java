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

@Service
public class CustomerServiceImpl implements CustomerService {

    public final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository)
    {this.customerRepository = customerRepository;}


    @Override
    public Customer save(Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> read(String s) {
        return this.customerRepository.findById(s);

    }

    @Override
    public void delete(Customer customer) {
        this.customerRepository.delete(customer);

    }

    // Finds Customer by customerID
    @Override
    public Customer findByCustomerId(String customerID) {
        return this.customerRepository.findByCustomerId(customerID);
    }

    @Override
    public void deleteCustomerByCustomerID(String customerID) {
        this.customerRepository.deleteCustomerByCustomerID(customerID);
    }


    // Finds Customer  by their firstname
    @Override
    public Optional<Customer> findByFirstName(String firstname) {
        return this.customerRepository.findByFirstName(firstname);

    }

    // List of all Employees
    @Override
    public List<Customer> findAll() {
        return this.customerRepository.findAll();
    }





    /*

     @Override
    public boolean delete(String customerID) {
       if ( this.customerRepository.existsByCustomerId(customerID)){
            this.customerRepository.deleteByCustomerId(customerID);
            return true;
       }
        return false;
    }


     // Checks if email valid and exist
    // true = exist
    // false = doesn't exist or not valid
    @Override
    public boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }


    // Checks if staffId valid and exist
    // true = exist
    // false = doesn't exist or not valid
    @Override
    public boolean existsByCustomerId(String customerID) {
        return this.repository.existsByCustomerId( customerID);
    }

    @Override
   public void deleteById(String id) {
        Optional<Customer> customer = read(id);
              if(customer.isPresent()){
                   delete(customer.get());
                }
    }
*/

    /*
    public Customer getCustomerByEmail(String email){
        List<Customer> list = this.repository.findByEmail(email);
        if (list.isEmpty())
            return  null;
        else
            return list.get(0);
    }
*/





}
