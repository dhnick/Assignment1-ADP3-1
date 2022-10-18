package za.ac.cput.serviceTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.factory.ReceptionistFactory;

import za.ac.cput.service.IReceptionistService;
import za.ac.cput.service.ReceptionistService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReceptionistServiceTest {

    private Receptionist receptionistRepository;
    private IReceptionistService service;


    @BeforeEach
    void setUp(){
        this.receptionistRepository =  ReceptionistFactory.createReceptionist("01",
                "13:00",
                "01",
                "Table for 1 at 13:00");

        this.service = ReceptionistService.getService();
    }

    @AfterEach
    void tearDown(){
        this.service.delete(this.receptionistRepository);

    }
    @Test
    public void save() {
        Receptionist saved = this.service.save(this.receptionistRepository);
        assertNotNull(saved);
        assertSame(this.receptionistRepository, saved);

    }

    @Test
    public void delete() {

        List<Receptionist> receptionistList = this.service.getAll();
        assertEquals(1, receptionistList.size());
        this.service.delete(this.receptionistRepository);
        receptionistList = this.service.getAll();
        assertEquals(0, receptionistList.size());
    }

    @Test
    public void read() {
        Receptionist saved = this.service.save(this.receptionistRepository);
        Optional<Receptionist> read = this.service.read(saved.getReceptionistID());
        assertAll(

                () -> assertTrue(read.isPresent()),
                () -> assertSame(saved, read.get())
        );
    }

    @Test
    public void findAll(){
        this.service.save(this.receptionistRepository);
        List<Receptionist> receptionistList = this.service.getAll();
        assertEquals(1, receptionistList.size());
    }
}
