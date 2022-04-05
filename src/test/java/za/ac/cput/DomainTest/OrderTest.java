/* OrderTest.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Order;

public class OrderTest {

    @Test
    public void test(){

        Order order1 = new Order.Builder()
                .setOrderID("67GD")
                .setOrderDetails("Seafood Platter")
                .setOrderType("Delivery")
                .setOrderQuantity(2)
                .build();

        Order newOrder = new Order.Builder()
                .setOrderID("89FG")
                .setOrderDetails(" Italian Pasta ")
                .setOrderType("Pick up")
                .setOrderQuantity(5)
                .build();

        System.out.println(order1);
        System.out.println(newOrder);



    }


}
