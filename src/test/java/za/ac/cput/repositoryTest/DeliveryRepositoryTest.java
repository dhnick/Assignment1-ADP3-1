package za.ac.cput.repositoryTest;
/*
   DeliveryRepositoryTest.java
    Implementation for DeliveryRepository
    Author: Jody Heideman (219307725)
    Date: 06/04/2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.repository.DeliveryRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class DeliveryRepositoryTest {

    private Delivery delivery;
    private DeliveryRepository repository;


    @BeforeEach
    void setUp(){
          this.delivery = DeliveryFactory.createDelivery(
                "01",
                "Pick-up",
                "15 Cresant street",
                "13:00"
        );

        this.repository = DeliveryRepository.getRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.delete(this.delivery);
    }


    @Test
    void save() {
        Delivery saved = this.repository.save(this.delivery);
        assertNotNull(saved);
        assertSame(this.delivery,saved);
    }

    @Test
    void read() {
        Delivery saved = this.repository.save(this.delivery);
        Optional<Delivery> read = this.repository.read(saved.getDeliveryID());
        assertTrue(read.isPresent());
        assertSame(saved, read.get());
    }

    @Test
    void delete() {
        Delivery saved = this.repository.save(this.delivery);
        List<Delivery> deliveryList = this.repository.getAll();
        assertEquals( 1, deliveryList.size());
        this.repository.delete(saved);
        deliveryList = this.repository.getAll();
        assertEquals( 0, deliveryList.size());


    }

    @Test
    void findAll() {
        this.repository.save(this.delivery);
        List<Delivery> studentAddressList = this.repository.getAll();
        assertEquals( 1, studentAddressList.size());




    }
}