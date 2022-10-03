/* CustomerRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class CustomerRepository {

    private List<Customer> customerList;
    private static CustomerRepository CUSTOMER_REPOSITORY;


    private CustomerRepository(){
      this.customerList = new ArrayList<>();
    }

    public static CustomerRepository getRepository() {
        if (CUSTOMER_REPOSITORY == null)
        {
            CUSTOMER_REPOSITORY = new CustomerRepository();
        }
        return CUSTOMER_REPOSITORY;
    }


    public Customer save (Customer customer) {
        Optional<Customer> read = read(customer.getCustomerID());
        if (read.isPresent()){
            delete(read.get());
        }
        this.customerList.add(customer);
        return customer;

    }


    public Optional <Customer>  read( String customerID) {
       return this.customerList.stream().filter(g -> g.getCustomerID().equalsIgnoreCase(customerID))
               .findFirst();
    }


    public void  delete(Customer customer) {
        this.customerList.remove(customer);

    }

    public List<Customer> findAll() { return this.customerList;}

    public List<Customer>findByCustomerId(String customerID) {
        return this.customerList.stream().filter( g -> g.getCustomerID().equalsIgnoreCase(customerID))
                .collect(Collectors.toList());
    }

    public Optional<Customer> findCustomerFirstNameByEmail(String email) {
        return this.customerList.stream().filter(  g -> g.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public boolean existsByEmail (String email) { return existsByEmail(email);}

    public boolean existsByCustomerId ( String customerID) { return  existsByCustomerId(customerID);}
}
