package za.ac.cput.factoryTest;

/* WaiterFactoryTest.Java
 *  Author: Tim Davids 219296219
 *  Entity for WaiterFactoryTest
 *  Date: 27 March 2022
 * */

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Waiters;
import za.ac.cput.factory.WaitersFactory;

import static org.junit.jupiter.api.Assertions.*;

class WaitersFactoryTest {

    @Test
    void createWaiter() {

        Waiters waiter = WaitersFactory.createWaiter("4532","Aiden","jameson","082187654");
        System.out.println(waiter.toString());
        assertNotNull(waiter);
    }
}