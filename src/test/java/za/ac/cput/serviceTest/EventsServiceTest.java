package za.ac.cput.serviceTest;
/*  EventsBookingTest
 *  Entity for EventsBookingTest
 *  Author: Yasmeen Nel (219250553)
 *  Date: October 2022
 * */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.service.impl.EventsServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventsServiceTest {

    @Autowired
    private EventsServiceImpl service;

    private final Event event =
            EventFactory.createEvent("1100","Wedding", "12 Jan 2022", "12:00");

    @Test
    void a_create() {
        Event create = service.create(event);
        assertEquals(create.getEventID(), event.getEventID());
        System.out.println("Saved: " + create);
    }

   /* @Test
    void b_read() {
        Optional<Event> read = service.read(event.getEventID());
        assertNotNull(read);
        System.out.println("read" + read);
    }*/

    @Test
    void c_update() {
        Event updated = new Event.Builder().copy(event)
                .setRequestedDate("31 December 2021")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated Date: " + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("1100");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }
}
