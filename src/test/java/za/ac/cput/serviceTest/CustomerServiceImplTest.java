package za.ac.cput.serviceTest;

/* CustomerServiceImplTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022

*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.service.impl.CustomerServiceImpl;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
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
    void a_create() {
        Customer created = service.create(customer);
        assertEquals(created.getCustomerID(), customer.getCustomerID());
        System.out.println("created" + created);
    }

    @Test
    void b_read() {
        Customer read = service.read(customer.getCustomerID());
        assertNotNull(read);
        System.out.println("read:" + read);
    }

    //Possible error
    @Test
    void c_update() {
        Customer old = service.read("#17485963");
        Customer updated = new Customer.Builder().copy(old)
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