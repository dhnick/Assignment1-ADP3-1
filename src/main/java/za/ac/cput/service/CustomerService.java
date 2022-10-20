package za.ac.cput.service;

/* CustomerService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/


import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Optional;


public interface CustomerService extends IService <Customer, String> {

    // Set<Customer>findAll ();
    List <Customer> findAll();
    //Customer findByCustomerId ( String customerID);
    //void deleteCustomerByCustomerID( String customerID);

    Customer update (Customer customer);
    boolean delete (String customerID);

    //Optional<Customer> findByFirstName ( String firstname);


}
