package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Order;
import za.ac.cput.Factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.*;

public class OrderFactoryTest {

     @Test
    public void test (){
         Order order = OrderFactory.createOrder(
                 "DH245",
                 "Gift",
                 "Online",
                 25);
         System.out.println(order.toString());
         assertNotNull(order);

     }


}
