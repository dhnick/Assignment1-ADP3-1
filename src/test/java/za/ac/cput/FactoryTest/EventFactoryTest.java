package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Event;
import za.ac.cput.Factory.EventFactory;

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