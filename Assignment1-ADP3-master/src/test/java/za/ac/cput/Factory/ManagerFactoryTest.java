package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Managers;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest {

    @Test
    public void test() {
        Managers managers = ManagerFactory.createManager("Tim","Davids");
        assertNotNull(managers);
    }

    @Test
    void createManager() {
    }
}