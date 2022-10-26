package za.ac.cput.factoryTest;
/* BookingsFactoryTest.Java
 *  Entity for BookingsFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Bookings;
import za.ac.cput.factory.BookingsFactory;

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