/* OrderFactoryTest.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

     @Test
    public void test (){
         Order order = OrderFactory.createOrder(
                 "67GD",
                 "Seafood Platter",
                 "Delivery",
                 2);
         System.out.println(order.toString());
         assertNotNull(order);

     }


}
