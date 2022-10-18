/* OrderFactoryTest.java
   Entity for order
   Author: Damone Hartnick
   Student Number : 219093717
   Date: April 2022
*/
package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Order;
import za.ac.cput.factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

     @Test
    public void test (){
         Order order = OrderFactory.createOrder(
                 "#DFD93138973",
                 "Friday Night Special",
                 "Medium",
                 2);
         System.out.println(order.toString());
         assertNotNull(order);

     }


}
