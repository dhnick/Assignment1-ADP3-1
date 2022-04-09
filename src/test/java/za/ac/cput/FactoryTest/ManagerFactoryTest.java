package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Managers;
import za.ac.cput.Factory.ManagerFactory;

import static org.junit.jupiter.api.Assertions.*;

class ManagerFactoryTest {

   @Test
    public void test() {

        Managers managers = ManagerFactory.createManager("3452" ,"Tim","Davids","35", "0823456798");
        System.out.println(managers.toString());
        assertNotNull(managers);
       System.out.println(managers);
    }


    @Test
    void createManager() {
   }
}