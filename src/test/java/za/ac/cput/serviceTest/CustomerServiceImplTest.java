package za.ac.cput.serviceTest;

/* CustomerServiceImplTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022

*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerServiceImpl;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl service;

    private final Customer customer =
            CustomerFactory.createCustomer("852963SQ",
            "Samatha",
            "Wilson",
            "Swilson@gmail.com",
            "34 New Way Street Crystal City",
            "082 963 7452");

    @Test
    void a_save() {
        Customer saved = service.save(customer);
        assertEquals(saved.getCustomerID(), customer.getCustomerID());
        System.out.println("saved" + saved);
    }

    @Test
    void b_read() {
        Optional<Customer> read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    //Possible error
    @Test
    void c_update() {
        Customer updated = new Customer.Builder().copy(customer)
                .setFirstName("Frank")
                .build();
       assertNotNull(service.update(updated));
        System.out.println("Updated FirstName " + "" + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("#1598537");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }




}