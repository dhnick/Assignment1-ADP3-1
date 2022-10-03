package za.ac.cput.service;

/* CustomerService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private final CustomerRepository repository;
    private static ICustomerService SERVICE ;

    private CustomerService() {this.repository = CustomerRepository.getRepository();}

    public static ICustomerService getService() {
         if ( SERVICE == null)
             SERVICE = new CustomerService();
         return SERVICE;

    }

    @Override
    public Customer save(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Optional<Customer> read(String s) {
        return this.repository.read(s);

    }

    @Override
    public void delete(Customer customer) {
        this.repository.delete(customer);

    }

    // List of all Employees
    @Override
    public List<Customer> findAll() {
        return this.repository.findAll();
    }
    // Finds Customer by customerID
    @Override
    public List<Customer> findByCustomerId(String customerID) {
        return this.repository.findByCustomerId(customerID);
    }

    // Finds CustomerFirstname by their email
    @Override
    public Optional<Customer> findCustomerFirstNameByEmail(String email) {
        return this.repository.findCustomerFirstNameByEmail(email);
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


}
