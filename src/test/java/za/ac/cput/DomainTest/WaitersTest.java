package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Waiters;
import za.ac.cput.factory.WaitersFactory;

class WaitersTest {

    @Test
    public void displayWaiters() {

        Waiters waiter = WaitersFactory
                .createWaiter("18753", "John", "Black", "0832165325");
        System.out.println(waiter);
    }
}