package za.ac.cput.factoryTest;
/* EventFactoryTest.Java
 *  Entity for EventFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;

import static org.junit.jupiter.api.Assertions.*;

class EventFactoryTest {
    @Test
    public void test(){
        Event event = EventFactory.createEvent("548484", "Molly's Birthday Party",
                "28 February 2022", "");
        System.out.println(event.toString());
        assertNotNull(event);

    }

}