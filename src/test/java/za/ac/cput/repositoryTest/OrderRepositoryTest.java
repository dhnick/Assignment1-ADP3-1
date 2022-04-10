/* IOrderRepository.java
   Entity for Customer
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.repositoryTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;
import za.ac.cput.repository.OrderRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)


public class OrderRepositoryTest {

    private  static OrderRepository repository = OrderRepository.getRepository();
    private static Order order = OrderFactory.createOrder(
            "67GD",
            "Seafood Platter",
            "Delivery",
            2);


    @Test
     void a_create() {
       Order created = repository.create(order);
       assertEquals(created.getOrderID(), order.getOrderID());
        System.out.println("Created: " + created);

    }

    @Test
    void b_read() {
        Order read = repository.read(order.getOrderID());
        System.out.println("Read :" + read);
    }

    @Test
    void c_update() {
        Order updateOrder = new Order.Builder().copy(order)
                .setOrderQuantity(5)
                .build();
        assertEquals(updateOrder.getOrderID(),order.getOrderID());
        System.out.println("Updated Order " + updateOrder);

    }

    @Test
    void d_delete() {
        repository.delete(order.getOrderID());
        assertNotNull(repository);
    }

    @Test
    void e_getAll() {
        System.out.println("Order: \n" + repository.getAll());
    }













}
