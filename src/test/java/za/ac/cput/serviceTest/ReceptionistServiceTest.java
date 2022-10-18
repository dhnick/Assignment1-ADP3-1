package za.ac.cput.serviceTest;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Delivery;
import za.ac.cput.domain.Receptionist;
import za.ac.cput.factory.ReceptionistFactory;

import za.ac.cput.service.IReceptionistService;
import za.ac.cput.service.ReceptionistService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)

public class ReceptionistServiceTest {

    private static ReceptionistService receptionistService = ReceptionistService.getService();
    private static Receptionist createdReceptionist =ReceptionistFactory.createReceptionist("01",
            "13:00",
            "01",
            "Table for 1 at 13:00");

    @Test
    void a_save() {
        Receptionist saved = receptionistService.save(createdReceptionist);
        assertEquals(saved.getReceptionistID(),createdReceptionist.getReceptionistID());
        System.out.println("ID#1: "+saved.getReceptionistID()+"\nID#2"+createdReceptionist.getReceptionistID()+"\n");

    }



    @Test
    void b_read() {
        Receptionist read = receptionistService.read(createdReceptionist.getReceptionistID());
        //Optional<Delivery> read = this.service.read(saved.getDeliveryID());

        assertNotNull(read);
        System.out.println("Reading ReceptionistId: "+read+"\n");
    }

    @Test
    void c_update(){

        Receptionist updated = new Receptionist.Builder().copy(createdReceptionist).setReceptionistID("02").build();
        assertNotNull(receptionistService.update(updated));

        System.out.println("Current receptionist ID: "+updated.getReceptionistID()+"\nOld delivery ID: "+createdReceptionist.getReceptionistID());

    }

    @Test
    void d_delete() {
        boolean deleted = receptionistService.delete(createdReceptionist.getReceptionistID());
        assertTrue(deleted);
        System.out.println("Deleted: "+deleted);
        e_findAll();
    }

    @Test
    void e_findAll(){
        System.out.println(receptionistService.getAll()+"\n");
    }

}
