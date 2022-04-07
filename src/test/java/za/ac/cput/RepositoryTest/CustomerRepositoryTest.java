/* CustomerRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Factory.CustomerFactory;
import za.ac.cput.Repository.CustomerRepository;


import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomerRepositoryTest {

    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.createCustomer(
            "25G",
            "Damone",
            "Hartnick",
            "219093717@mycput.ac.za",
            "22 Jump Street",
            "087 877 7285");

    @Order(1)
    @Test
    void create() {
        Customer created = repository.create(customer);
        assertEquals(created.getCustomerID(), customer.getCustomerID());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    void read() {
        Customer read = repository.read(customer.getCustomerID());
        System.out.println("Read: " + read);

    }
    @Order(3)
    @Test
    void update() {
        Customer updateCustomer = new Customer.Builder().copy(customer)
                .setAddress(" 26 Rose Street")
                .setContactNumber("067 857 7200")
                .build();
        assertEquals(updateCustomer.getCustomerID(), customer.getCustomerID());
        System.out.println("Updated Customer: " + updateCustomer);
    }
    @Order(4)
    @Test
    void delete() {
        repository.delete(customer.getCustomerID());
        assertNotNull(repository);
    }
    @Order(5)
    @Test
    void getAll() {
        System.out.println("Customers: \n" + repository.getAll());


    }





}
