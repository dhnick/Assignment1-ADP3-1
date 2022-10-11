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

//SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceImplTest {

    @Autowired
    private CustomerServiceImpl service;

    private Customer customer1 = CustomerFactory.createCustomer("852963SQ",
            "Samatha",
            "Wilson",
            "Swilson@gmail.com",
            "34 New Way Street Crystal City",
            "082 963 7452");

    private Customer customer2 = CustomerFactory.createCustomer("159753WE",
            "Wilmien",
            "Earns",
            "EarnsW1@gmail.com",
            "01 Rose Street New City",
            "078 753 7412");;




    @Test
    @Order(1)
    void save() {
        Customer CustomerSaved1 = this.service.save(customer1);
        Customer CustomerSaved2 = this.service.save(customer2);
        assertAll(
                () -> assertNotNull(CustomerSaved1),
                () -> assertNotNull(CustomerSaved2)
        );


    }

    @Test
    @Order(2)
    void read() {

        assertEquals(this.service.read(customer1.getCustomerID()), customer1.getCustomerID());

        /*
        Optional<Customer> read = service.read(customer1.getCustomerID());
        assertEquals(read.get(), customer1.getCustomerID());
        System.out.println("Read:" + read);

         */

    }

    @Test
    @Order(3)
    void delete() {
        this.service.delete(this.customer2);
        System.out.println("Deleted: ");

    }




    @Test
    @Order(4)
    void findByCustomerId() {
        Customer customer = service.findByCustomerId(customer1.getCustomerID());
        System.out.println("Find: " + customer1.getCustomerID() + "");
        System.out.println(customer);
    }


    @Test
    @Order(5)
    void findByFirstName() {
        Optional<Customer> customer = service.findByFirstName(customer1.getFirstName());
        System.out.println("Find: "  + customer1.getFirstName() + "");
        System.out.println(customer);

    }

    @Test
    @Order(6)
    void findAll() {
        System.out.println("Find All: ");
        System.out.println(service.findAll());
    }


    /*
        @Test
    @Order(1)
    void setUp() {
        customer1 = CustomerFactory.createCustomer("852963SQ",
                "Samatha",
                "Wilson",
                "Swilson@gmail.com",
                "34 New Way Street Crystal City",
                "082 963 7452");
        assertNotNull(customer1);
        System.out.println(customer1);

        customer2 = CustomerFactory.createCustomer("159753WE",
                "Wilmien",
                "Earns",
                "EarnsW1@gmail.com",
                "01 Rose Street New City",
                "078 753 7412");
        assertNotNull(customer2);
        System.out.println(customer2);
    }

     Customer created1 = service.save(customer1);
        assertNotNull(created1);
        System.out.println("created:" + created1);

        Customer created2= service.save(customer2);
        assertNotNull(created2);
        System.out.println("created:" + created2);
*/


}