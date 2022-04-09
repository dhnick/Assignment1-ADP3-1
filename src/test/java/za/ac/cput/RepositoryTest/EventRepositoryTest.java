package za.ac.cput.RepositoryTest;
/*  EventRepositoryTest.Java
 *  Entity for EventRepositoryTest
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Bookings;
import za.ac.cput.Domain.Event;
import za.ac.cput.Factory.BookingsFactory;
import za.ac.cput.Factory.EventFactory;
import za.ac.cput.Repository.BookingsRepository;
import za.ac.cput.Repository.EventRepository;

import static org.junit.jupiter.api.Assertions.*;

class  EventRepositoryTest{
    private static EventRepository repository = EventRepository.getRepository();
    private static Event event = EventFactory.createEvent("219250553",
            "Janets Brunch","22 March 2022",
            "A high tea");

    @Test
    void create() {
        Event bookEvent = repository.create(event);
        assertNotNull(bookEvent);
        assertEquals(event.getEventID(), bookEvent.getEventID());
        System.out.println("This event was created," + bookEvent);
    }

    @Test
    void read() {
        Event read = repository.read(event.getEventID());
        System.out.println("Event " + read);
    }

    @Test
    void update() {
        Event eventUpdated = new Event.Builder().copy(event)
                .setEventTheme("Late Brunch")
                .setRequestedDate("5 May 2022")
                .build();
        assertEquals(eventUpdated.getEventID(), event.getEventID());
        System.out.println("Booking Changes " + eventUpdated);
    }

    @Test
    void delete() {
        repository.delete(event.getEventID());
        assertNotNull(event);
    }

    @Test
    void getAll() {
        System.out.println("All Events:");
        System.out.println(repository.getAll());
    }
}