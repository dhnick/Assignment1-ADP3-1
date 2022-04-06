package za.ac.cput.FactoryTest;
/*
    DeliveryFactoryTest.java
    Test for DeliveryFactory class
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Delivery;
import za.ac.cput.Factory.DeliveryFactory;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryFactoryTest {

    @Test
    public void test(){
        Delivery delivery = DeliveryFactory.createDelivery("155","Jody" ,"2 Johnson road" ,"15:00" );
         assertNotNull(delivery);
        System.out.println(delivery);
    }

}