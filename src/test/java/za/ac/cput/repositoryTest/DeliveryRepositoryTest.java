package za.ac.cput.repositoryTest;
/*
   DeliveryRepositoryTest.java
    Implementation for DeliveryRepository
    Author: Jody Heideman (219307725)
    Date: 06/04/2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.repository.DeliveryRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryRepositoryTest {

    private static DeliveryRepository repository = DeliveryRepository.getRepository();
    private static Delivery delivery = DeliveryFactory.createDelivery
            ("15926348" , "Uber eats","2 Johnson road","15:00");
    @Test
    void a_create() {
        Delivery created = repository.create(delivery);
        assertNotNull(created);
        assertEquals(delivery.getDeliveryID() , created.getDeliveryID());
        System.out.println("Created delivery, " + created);
    }

    @Test
    void b_read() {
        Delivery read = repository.read(delivery.getDeliveryID());
        assertEquals(delivery.getDeliveryID() , read.getDeliveryID());
        System.out.println("Read delivery id, " + read);
    }

    @Test
    void c_update() {
        Delivery updated = new Delivery.Builder().copy(delivery)
                .setDeliveryID("15926348")
                .setDeliveryMethod("Uber Eats")
                .setDeliveryAddress("20 Cliffoney street")
                .setDeliveryTime("13:00")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated delivery, " + updated);
    }

    @Test
    void e_delete() {
        repository.delete(delivery.getDeliveryID());
        assertNotNull(delivery);

    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}