package za.ac.cput.repositoryTest;
/*
    ReceptionistRepositoryTest.java
    Implementation for ReceptionistRepository
    Author: Jody Heideman (219307725)
    Date: 06/04/2022
 */
import org.junit.jupiter.api.*;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.factory.DeliveryFactory;
import za.ac.cput.factory.ReceptionistFactory;
import za.ac.cput.repository.DeliveryRepository;
import za.ac.cput.repository.ReceptionistRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReceptionistRepositoryTest {

    private Receptionist receptionist;
    private ReceptionistRepository repository;


    @BeforeEach
    void setUp(){
        this.receptionist = ReceptionistFactory.createReceptionist("01",
                "13:00",
                "01",
                "Table for 1 at 13:00");

        this.repository = ReceptionistRepository.getRepository();
    }

    @AfterEach
    void tearDown(){
        this.repository.delete(this.receptionist);
    }


    @Test
    void save() {
        Receptionist saved = this.repository.save(this.receptionist);
        assertNotNull(saved);
        assertSame(this.receptionist,saved);
    }

    @Test
    void read() {
        Receptionist saved = this.repository.save(this.receptionist);
        Optional<Receptionist> read = this.repository.read(saved.getReceptionistID());
        assertTrue(read.isPresent());
        assertSame(saved, read.get());
    }

    @Test
    void delete() {
        Receptionist saved = this.repository.save(this.receptionist);
        List<Receptionist> receptionistList = this.repository.getAll();
        assertEquals( 1, receptionistList.size());
        this.repository.delete(saved);
        receptionistList = this.repository.getAll();
        assertEquals( 0, receptionistList.size());

    }

    @Test
    void findAll() {
        this.repository.save(this.receptionist);
        List<Receptionist> receptionistList = this.repository.getAll();
        assertEquals( 1, receptionistList.size());

    }
}