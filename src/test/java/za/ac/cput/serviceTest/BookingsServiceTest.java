package za.ac.cput.serviceTest;
/*  BookingsServiceTest
 *  Entity for BookingsServiceTest
 *  Author: Yasmeen Nel (219250553)
 *  Date: October 2022
 * */
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Bookings;
import za.ac.cput.factory.BookingsFactory;
import za.ac.cput.service.impl.BookingsServiceImp;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingsServiceTest {

    @Autowired
    private BookingsServiceImp service;

    private final Bookings bookings =
            BookingsFactory.createBooking("0001", "Courtyard",
                    "12 January 2023", "Wedding Anniversary", "50 People");

    @Test
    void a_save() {
        Bookings saved = service.save(bookings);
        assertEquals(saved.getBookingID(), bookings.getBookingID());
        System.out.println("Saved: " + saved);
    }

    @Test
    void b_read() {
        Bookings read = service.read(bookings.getBookingID());
        assertNotNull(read);
        System.out.println("read" + read);
    }

    @Test
    void c_update() {
        Bookings updated = new Bookings.Builder().copy(bookings)
                .setBookingDate("31 December 2021")
                .build();
        assertNotNull(service.update(updated));
        System.out.println("Updated Date: " + updated);

    }

    @Test
    void e_delete() {
        boolean done = service.delete("002");
        assertTrue(done);
        System.out.println("successfully deleted " + "" + done);

    }

    @Test
    void d_findAll() {
        System.out.println("Display all");
        System.out.println(service.findAll());

    }
}
