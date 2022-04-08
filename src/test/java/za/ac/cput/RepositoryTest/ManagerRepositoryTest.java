package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Delivery;
import za.ac.cput.Domain.Managers;
import za.ac.cput.Factory.DeliveryFactory;
import za.ac.cput.Factory.ManagerFactory;
import za.ac.cput.Repository.DeliveryRepository;
import za.ac.cput.Repository.ManagerRepository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerRepositoryTest {

    private static ManagerRepository repository = ManagerRepository.getRepository();
    private static Managers manager = ManagerFactory.createManager("324567","Jason","River" ,"42", "075432213");

    @Test
    void create() {
        Managers created = repository.create(manager);
        assertNotNull(created);
        assertEquals(Managers.getManagerID() , created.getManagerID());
        System.out.println("Created Manager, " + created);
    }

    @Test
    void read() {
        Managers read = repository.read(Managers.getManagerID());
        //assertNotNull(read);
        assertEquals(Managers.getManagerID() , read.getManagerID());
        System.out.println("Read Manager's ID, " + read);
    }

    @Test
    void update() {

        Managers updated = new Managers.Builder().copy(manager)
                .setManagerID("21345")
                .setFirstname("Amy")
                .setSurname("Brown")
                .setAge("35")
                .setContactNumber("0789654345")
                .build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated Managers List, " + updated);

    }

    @Test
    void delete() {

        repository.delete(Managers.getManagerID());
        assertNotNull(manager);
    }

    @Test
    void getAll() {
        System.out.println("Listing all Managers ");
        System.out.println(repository.getAll());
    }
}