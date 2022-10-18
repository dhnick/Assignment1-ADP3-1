package za.ac.cput.serviceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.service.DeliveryService;
import za.ac.cput.service.IDeliveryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryServiceTest {
    private Delivery deliveryRepository;
    private IDeliveryService service;


    @BeforeEach
    void setUp(){
        this.deliveryRepository = DeliveryFactory.createDelivery(
                "01",
                "Pick-up",
                "15 Cresant street",
                "13:00"
        );

        this.service = DeliveryService.getService();
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.deliveryRepository);

    }
    @Test
    public void save() {
        Delivery saved = this.service.save(this.deliveryRepository);
        assertNotNull(saved);
        assertSame(this.deliveryRepository, saved);

    }

    @Test
    public void delete() {

        List<Delivery> deliveryList = this.service.getAll();
        assertEquals(1, deliveryList.size());
        this.service.delete(this.deliveryRepository);
        deliveryList = this.service.getAll();
        assertEquals(0, deliveryList.size());
    }

    @Test
    public void read() {
        Delivery saved = this.service.save(this.deliveryRepository);
        Optional<Delivery> read = this.service.read(saved.getDeliveryID());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.service.save(this.deliveryRepository);
        List<Delivery> deliveryList = this.service.getAll();
        assertEquals(1, deliveryList.size());
    }

}
