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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private final Order order =
            OrderFactory.createOrder(
            "#565678",
            "Family Special",
            "Large",
            4) ;



    @Test
    void a_save() {
        Order saved = service.save(order);
        assertEquals(saved.getOrderID(), order.getOrderID());
        System.out.println("saved" + saved);
    }

    @Test
    void b_read() {
        Optional<Order> read = service.read(order.getOrderID());
        assertNotNull(read);
        System.out.println("read" + read);

    }

    @Test
    void c_update() {
        Optional<Order> old = service.read("#2521478");
        Order updated  = new Order.Builder().copy(old)
                .setOrderDetails("Large")
                .setOrderType("Medium")
                .setOrderQuantity(5)
                .build();
        assertNotNull(service.update(updated));
        System.out.println("updated" + " " + updated);
    }

    @Test
    void c_delete() {
        boolean done = service.delete("#1478963");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);
    }

    @Test
    void g_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }



}


