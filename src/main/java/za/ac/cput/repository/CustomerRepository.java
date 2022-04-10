/* CustomerRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repository;

import za.ac.cput.domain.Customer;

import java.util.HashSet;
import java.util.Set;

public class CustomerRepository implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private  Set<Customer> customerDB = null;

    private CustomerRepository(){
      customerDB = new HashSet<Customer>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null)
        {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        this.customerDB.add(customer);
        return customer;


    }

    @Override
    public Customer read( String customerID) {
        for (Customer c : customerDB) {
            if (c.getCustomerID().equals(customerID)) {
                return c;
            }
        }
        return null;

    }

    @Override
    public Customer update(Customer customer) {
        Customer firstCustomer = read(customer.getCustomerID());
        if (firstCustomer != null) {
            customerDB.remove(firstCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public void  delete(String customerID) {
        Customer deleteCustomer = read(customerID);
        if (deleteCustomer == null) {
            System.out.println("Customer is null.");
        }
        customerDB.remove(deleteCustomer);
        System.out.println("Customer has been  removed.");

    }

    @Override
    public Set<Customer> getAll() {
        return customerDB;
    }

}
