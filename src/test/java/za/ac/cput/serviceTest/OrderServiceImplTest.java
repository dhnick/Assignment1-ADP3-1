package za.ac.cput.serviceTest;

/* OrderServiceImplTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Customer;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.impl.OrderServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private Order order1 = OrderFactory.createOrder("56S2D",
            "Family Special",
            "Large",
            4) ;


    private Order order2 = OrderFactory.createOrder("#985422",
            "Sunday Special",
            "Large",
            2);




    @Test
    @org.junit.jupiter.api.Order(1)
    void save() {
        Order orderSaved1 = this.service.save(order1);
        Order orderSaved2 = this.service.save(order2);

        assertAll(
                () -> assertNotNull(orderSaved1),
                () -> assertNotNull(orderSaved2)
        );

    }

    @Test
    @org.junit.jupiter.api.Order(2)
    void read() {
        assertEquals(this.service.read(order1.getOrderID()), order1.getOrderID());

    }

    @Test
    @org.junit.jupiter.api.Order(3)
    void delete() {
        this.service.delete(order1);

    }

    @Test
    @org.junit.jupiter.api.Order(4)
    void findByOrderId() {
        Order order = service.findByOrderId(order1.getOrderID());
        System.out.println("Find: " + order1.getOrderID() + "");
        System.out.println(order);
    }


    @Test
    @org.junit.jupiter.api.Order(5)
    void findAll() {
        System.out.println("Find All: ");
        System.out.println(service.findAll());
    }


}