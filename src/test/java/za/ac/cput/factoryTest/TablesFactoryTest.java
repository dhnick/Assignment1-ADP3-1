package za.ac.cput.factoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Tables;
import za.ac.cput.factory.TablesFactory;

import static org.junit.jupiter.api.Assertions.*;
//chulumano buhle Nkwinda
//219390983
//adp3
class TablesFactoryTest {

    @Test
    public void test(){
        Tables tables = TablesFactory.createTables(
                "252022", "good","to much","crowsfoot"
        );
        System.out.println(tables.toString());
        assertNotNull(tables);

    }
}