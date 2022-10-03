package za.ac.cput.service;

/* ICustomerService.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface ICustomerService extends IService <Customer, String> {

    public List <Customer> findAll();
    List<Customer> findByCustomerId ( String customerID);

    Optional<Customer> findCustomerFirstNameByEmail ( String email);

    boolean existsByEmail ( String email);

    boolean existsByCustomerId( String customerID);
    void deleteById(String id);

    // findByFirstName using customer email
    // check email valid and exist
    // check customerID valid and exist






}
