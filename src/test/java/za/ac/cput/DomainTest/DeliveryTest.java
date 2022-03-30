package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Delivery;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTest {

    @Test
    public void Test(){

            Delivery delivery = new Delivery.Builder()
                    .setDeliveryID(55555)
                    .setDeliveryMethod("Uber eats")
                    .setDeliveryAddress("2 Johnson road")
                    .setDeliveryTime("15:00")
                    .build();
            Delivery delivery1 = new Delivery.Builder()
                        .setDeliveryID(21930)
                                .build();

            System.out.println(delivery.toString());
            System.out.println(delivery1.toString());

    }

}