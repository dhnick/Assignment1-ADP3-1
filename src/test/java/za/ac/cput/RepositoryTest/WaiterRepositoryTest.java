package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Waiters;
import za.ac.cput.Factory.WaitersFactory;
import za.ac.cput.Repository.WaiterRepository;

import static org.junit.jupiter.api.Assertions.*;

class WaiterRepositoryTest {

    private static final WaiterRepository repository = WaiterRepository.getRepository();
    private static final Waiters waiter = WaitersFactory.createWaiter("324567","Jason","River" , "075432213");

    @Test
    void create() {

        Waiters created = repository.create(waiter);
        assertNotNull(created);
        assertEquals(Waiters.getStaffID() , created.getStaffID());
        System.out.println("Created Staff member, " + created);
    }

    @Test
    void read() {
        Waiters read = repository.read(Waiters.getStaffID());
        //assertNotNull(read);
        assertEquals(Waiters.getStaffID() , read.getStaffID());
        System.out.println("Read Waiter's ID, " + read);
    }

    @Test
    void update() {

        Waiters updated = new Waiters.builder().copy(waiter)
                .setStaffID("234567")
                .setFirstname("Mason ")
                .setSurname("Andrews")
                .setContactNumber("0863456213")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated Managers List, " + updated);
    }

    @Test
    void delete() {
        repository.delete(Waiters.getStaffID());
        assertNotNull(waiter);
    }

    @Test
    void getAll() {
        System.out.println("Listing all Waiters ");
        System.out.println(repository.getAll());
    }
}