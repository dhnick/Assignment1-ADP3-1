package za.ac.cput.Domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagersTest {
    @Test
    public void test(){
        Managers managers = new Managers("Tim","Davids");
        Managers newManagers = new Managers("Tim","Davids");
                System.out.println(Managers.String);
    }

}