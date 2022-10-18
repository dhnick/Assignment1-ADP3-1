package za.ac.cput.serviceTest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.IDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
@DataJpaTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class DeliveryServiceTest {
    private static IDeliveryService deliveryService = DeliveryService.getService();

    private static Delivery createdDelivery = DeliveryFactory.createDelivery(
            "01",
            "Pick-up",
            "15 Cresant street",
            "13:00"
    );

    @Test
     void a_save() {
        Delivery saved = deliveryService.save(createdDelivery);
        assertEquals(saved.getDeliveryID(),createdDelivery.getDeliveryID());
        System.out.println("ID#1: "+saved.getDeliveryID()+"\nID#2"+createdDelivery.getDeliveryID()+"\n");

    }



    @Test
     void b_read() {
        Delivery read = deliveryService.read(createdDelivery.getDeliveryID());
        //Optional<Delivery> read = this.service.read(saved.getDeliveryID());

        assertNotNull(read);
        System.out.println("Reading DeliveryID: "+read+"\n");
    }

    @Test
    void c_update(){

        Delivery updated = new Delivery.Builder().copy(createdDelivery).setDeliveryID("02").build();
        assertNotNull(deliveryService.update(updated));

        System.out.println("Current delivery ID: "+updated.getDeliveryID()+"\nOld delivery ID: "+createdDelivery.getDeliveryID());

    }

    @Test
    void d_delete() {
        boolean deleted = deliveryService.delete(createdDelivery.getDeliveryID());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_findAll();
    }

    @Test
     void e_findAll(){
        System.out.println(deliveryService.getAll()+"\n");
    }

}
