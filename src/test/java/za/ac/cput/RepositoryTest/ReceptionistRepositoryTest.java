package za.ac.cput.RepositoryTest;
/*
    ReceptionistRepositoryTest.java
    Implementation for ReceptionistRepository
    Author: Jody Heideman (219307725)
    Date: 06/04/2022
 */
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Domain.Receptionist;
import za.ac.cput.Factory.ReceptionistFactory;
import za.ac.cput.Repository.ReceptionistRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ReceptionistRepositoryTest {

    private static ReceptionistRepository repository = ReceptionistRepository.getRepository();
    private static Receptionist receptionist = ReceptionistFactory.createReceptionist("481592637" ,1600,5,"Table for 5 at 16:00");
    @Test
    void a_create() {
        Receptionist created = repository.create(receptionist);
        assertNotNull(created);
        assertEquals(receptionist.getReceptionistID() , created.getReceptionistID());
        System.out.println("Created receptionist, " + created);
    }

    @Test
    void b_read() {
        Receptionist read = repository.read(receptionist.getReceptionistID());
        //assertNotNull(read);
        assertEquals(receptionist.getReceptionistID() , read.getReceptionistID());
        System.out.println("Read receptionist id, " + read);
    }

    @Test
    void c_update() {
        Receptionist updated = new Receptionist.Builder().copy(receptionist)
                .setReceptionistID("481592637")
                .setNumberOfPeople(7)
                .setReceptionistTime(1900)
                .setCreateReservation("Table for 7 at 19:00")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated receptionist, " + updated);
    }

    @Test
    void e_delete() {
     repository.delete(receptionist.getReceptionistID());
    assertNotNull(receptionist);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}