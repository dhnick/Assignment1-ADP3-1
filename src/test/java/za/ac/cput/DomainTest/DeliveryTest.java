package za.ac.cput.DomainTest;
/*
    DeliveryTest.java
    Test case for DeliveryTest
    Author: Jody Heideman (219307725)
    Date: 27/03/2022
 */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Delivery;

class DeliveryTest {

    @Test
    public void Test(){

            Delivery delivery = new Delivery.Builder()
                    .setDeliveryID("55555")
                    .setDeliveryMethod("Uber eats")
                    .setDeliveryAddress("2 Johnson road")
                    .setDeliveryTime("15:00")
                    .build();
            Delivery delivery1 = new Delivery.Builder()
                        .setDeliveryID("21930")
                                .build();

            System.out.println(delivery.toString());
            System.out.println(delivery1.toString());

    }

}