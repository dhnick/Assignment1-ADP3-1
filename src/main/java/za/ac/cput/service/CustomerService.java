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

    List <Customer> findAll();
    Customer findByCustomerId ( String customerID);
    void deleteCustomerByCustomerID( String customerID);


    Optional<Customer> findByFirstName ( String firstname);


    //boolean existsByEmail ( String email);

    //boolean existsByCustomerId( String customerID);
    //void deleteById(String id);

    //boolean delete(String customerID); // new

    // findByFirstName
    // check email valid and exist
    // check customerID valid and exist

}
