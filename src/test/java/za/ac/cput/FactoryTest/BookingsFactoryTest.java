package za.ac.cput.FactoryTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Bookings;
import za.ac.cput.Factory.BookingsFactory;

import static org.junit.jupiter.api.Assertions.*;

class BookingsFactoryTest {
    @Test
    public void test(){
        Bookings booking = BookingsFactory.createBooking("55555", "Melissa Anniversary",
                "25 May 2022", "Vanilla cake", "Recent Package");

        System.out.println(booking.toString());
        assertNotNull(booking);

    }

}