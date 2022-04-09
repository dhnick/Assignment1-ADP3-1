package za.ac.cput.DomainTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Waiters;
import za.ac.cput.Factory.WaitersFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WaitersTest {

    @Test
    public void displayWaiters() {

        Waiters waiter = WaitersFactory
                .createWaiter("18753", "John", "Black", "0832165325");
        System.out.println(waiter);
    }
}