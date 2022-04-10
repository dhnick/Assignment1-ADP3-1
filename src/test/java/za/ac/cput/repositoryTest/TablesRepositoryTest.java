package za.ac.cput.repositoryTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;
import za.ac.cput.repository.TableRepository;

import static org.junit.jupiter.api.Assertions.*;
//chulumano buhle Nkwinda
//219390983
//adp3
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TablesRepositoryTest {

    private static TableRepository repository = TableRepository.getRepository();
    private static Tables tables = TablesFactory.createTables(
            "22 row","polo","good","leli"
    );

    @Order(1)
    @Test
    void create() {
        Tables created = repository.create(tables);
        //assertArrayEquals(created.getTableID(), tables.getTableID());
        System.out.println("created" + created);
    }

@Order(2)
@Test
void read(){
        Tables read = repository.read(tables.getTableID());
    System.out.println("Read"+ read);
}
@Order(3)
    @Test
    void update(){
        Tables updateTables = new Tables.TablesBuilder().copy(tables).setCapacity("55515").setTableID("5454").setTableStatus("6645").setTableType("djhsgj").build();
        //assertEquals(updateTables.getTableID()),tables.getTableID();
    System.out.println("updated Table"+ updateTables);
}
@Order(4)
    @Test
    void delete(){
        repository.delete(tables.getTableID());
        assertNotNull(repository);
}
@Order(5)
    @Test
    void getAll(){
        System.out.println("tables : /n" + repository.getAll());
    }
}