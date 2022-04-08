package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Managers;
import za.ac.cput.Factory.ManagerFactory;

class ManagersTest {
    @Test
    public void displayManagers() {

        Managers managers = ManagerFactory
                .createManager("123456 ", "Tim", "Davids", "23","0214567323");
        System.out.println(managers);
  }

}