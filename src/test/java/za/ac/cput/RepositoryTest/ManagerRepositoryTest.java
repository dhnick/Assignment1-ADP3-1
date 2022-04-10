package za.ac.cput.RepositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Managers;
import za.ac.cput.factory.ManagerFactory;
import za.ac.cput.repository.ManagerRepository;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
class ManagerRepositoryTest {

    private static ManagerRepository repository = ManagerRepository.getRepository();
    private static Managers manager = ManagerFactory.createManager("324567","Jason","River" ,"42", "075432213");

    @Test
    void a_create() {
        Managers created = repository.create(manager);
        assertNotNull(created);
        assertEquals(Managers.getManagerID() , created.getManagerID());
        System.out.println("Created Manager, " + created);
    }

    @Test
    void b_read() {
        Managers read = repository.read(Managers.getManagerID());
        //assertNotNull(read);
        assertEquals(Managers.getManagerID() , read.getManagerID());
        System.out.println("Read Manager's ID, " + read);
    }

    @Test
    void c_update() {

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
    void e_delete() {

        repository.delete(Managers.getManagerID());
        assertNotNull(manager);
    }

    @Test
    void d_getAll() {
        System.out.println("Listing all Managers ");
        System.out.println(repository.getAll());
    }
}