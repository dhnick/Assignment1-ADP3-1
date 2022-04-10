package za.ac.cput.DomainTest;
/*  BookingsTest.Java
 *  Test Entity for the Bookings
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Bookings;

class BookingsTest {
    @Test
    public void test(){
        Bookings booking1 = new Bookings.Builder().setBookingID("515151")
                        .setBookingTitle("Jan's Birthday Party")
                        .setBookingDate("12 March 2022")
                        .setBookingDescription("30 Children and 10 Adults")
                        .setBookingPackage("The expensive one")
                        .build();
        Bookings newBooking = new Bookings.Builder().setBookingTitle("Harry's Anniversary")
                        .setBookingDate("15 April 2022")
                        .build();
        System.out.println(booking1);
        System.out.println(newBooking);
    }

}