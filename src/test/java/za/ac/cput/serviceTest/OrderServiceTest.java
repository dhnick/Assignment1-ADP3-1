package za.ac.cput.serviceTest;

/* OrderServiceTest.java
   Author: Damone Hartnick
   Student Number : 219093717
   Date: August 2022
*/

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.service.IOrderService;
import za.ac.cput.service.OrderService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    @Mock
    private Order orderRepository;

    @InjectMocks
    private IOrderService service;


    @BeforeEach
    void setUp() {

        this.orderRepository = OrderFactory.createOrder(
                "56S2D",
                "Family Special",
                "Large",
                4
        );

        this.service = OrderService.getService();


    }

    @AfterEach
    void tearDown() {
        this.service.delete(this.orderRepository);
    }

    @Test
    void save() {
        Order saved = this.service.save(this.orderRepository);
        assertNotNull(saved);
        assertSame(this.orderRepository, saved);
    }

    @Test
    void read() {
        Order saved = this.service.save(this.orderRepository);
        Optional<Order> read = this.service.read(saved.getOrderID());
        assertAll(
                () -> assertTrue(read.isPresent()),
                () ->assertSame(saved,read.get())

        );
    }

    @Test
    void delete() {
        Order saved = this.service.save(this.orderRepository);
        List<Order> orderList= this.service.findAll();
        assertEquals(1, orderList.size());
        this.service.delete(saved);
        orderList= this.service.findAll();
        assertEquals(0,orderList.size());
    }

    @Test
    void findAll() {
        this.service.save(this.orderRepository);
        List<Order> customerList= this.service.findAll();
        assertEquals(1,customerList.size());
    }

    @Test
    void findByOrderId() {
        this.service.findByOrderId("56S2D");
        List<Order> customerList= this.service.findByOrderId(orderRepository.getOrderID());
        System.out.println(orderRepository);
        assertNotNull(customerList);

    }
}