package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Managers;
import za.ac.cput.Domain.Waiters;
import za.ac.cput.Factory.WaitersFactory;

import static org.junit.jupiter.api.Assertions.*;

class WaitersFactoryTest {

    @Test
    void createWaiter() {

        Waiters waiter = WaitersFactory.createWaiter("4532","Aiden","jameson","082187654");
        System.out.println(waiter.toString());
        assertNotNull(waiter);
    }
}