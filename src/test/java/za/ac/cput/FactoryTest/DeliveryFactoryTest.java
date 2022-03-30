package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Delivery;
import za.ac.cput.Factory.DeliveryFactory;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryFactoryTest {

    @Test
    public void test(){
        Delivery delivery = DeliveryFactory.createDelivery(155,"Jody" ,"2 Johnson road" ,"15:00" );
         assertNotNull(delivery);
        System.out.println(delivery);
    }

}