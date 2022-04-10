package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Waiters;
import za.ac.cput.factory.WaitersFactory;
import za.ac.cput.repository.WaiterRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class WaiterRepositoryTest {

    private static final WaiterRepository repository = WaiterRepository.getRepository();
    private static final Waiters waiter = WaitersFactory.createWaiter("324567","Jason","River" , "075432213");

    @Test
    void a_create() {

        Waiters created = repository.create(waiter);
        assertNotNull(created);
        assertEquals(Waiters.getStaffID() , created.getStaffID());
        System.out.println("Created Staff member, " + created);
    }

    @Test
    void b_read() {
        Waiters read = repository.read(Waiters.getStaffID());
        assertEquals(Waiters.getStaffID() , read.getStaffID());
        System.out.println("Read Waiter's ID, " + read);
    }

    @Test
    void c_update() {

        Waiters updated = new Waiters.Builder().copy(waiter)
                .setStaffID("2342")
                .setFirstname("Mason ")
                .setSurname("Andrews")
                .setContactNumber("0863456213")
                .build();

        assertNotNull(repository.update(updated));
        System.out.println("Updated Managers List, " + updated);
    }

    @Test
    void e_delete() {
        repository.delete(Waiters.getStaffID());
        assertNotNull(waiter);
    }

    @Test
    void d_getAll() {
        System.out.println("Listing all Waiters ");
        System.out.println(repository.getAll());
    }
}