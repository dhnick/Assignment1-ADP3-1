package za.ac.cput.RepositoryTest;
/*  BookingsRepositoryTest.Java
 *  Entity for BookingsRepositoryTest
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Bookings;
import za.ac.cput.Domain.Customer;
import za.ac.cput.Factory.BookingsFactory;
import za.ac.cput.Repository.BookingsRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookingsRepositoryTest {
    private static BookingsRepository repository = BookingsRepository.getRepository();
    private static Bookings booking = BookingsFactory.createBooking("219250553",
            "Jannets Birthday","21 March 2022",
            "Wants a Vanilla cake, 13 patrons","R1500 Birthday Special");

    @Test
    void create() {
        Bookings book = repository.create(booking);
        assertNotNull(book);
        assertEquals(booking.getBookingID(), book.getBookingID());
        System.out.println("This booking was created," + book);
    }

    @Test
    void read() {
        Bookings read = repository.read(booking.getBookingID());
        System.out.println("Booking " + read);
    }

    @Test
    void update() {
        Bookings bookingUpdated = new Bookings.Builder().copy(booking)
                .setBookingDescription("Wants a Vanilla Cake, 20 Patrons")
                .setBookingPackage("R2000 Normal package")
                .build();
        assertEquals(bookingUpdated.getBookingID(), booking.getBookingID());
        System.out.println("Booking Changes " + bookingUpdated);
    }

    @Test
    void delete() {
        repository.delete(booking.getBookingID());
        assertNotNull(booking);
    }

    @Test
    void getAll() {
        System.out.println("All Bookings:");
        System.out.println(repository.getAll());
    }
}