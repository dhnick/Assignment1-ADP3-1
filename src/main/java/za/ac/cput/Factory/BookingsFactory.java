package za.ac.cput.Factory;

import za.ac.cput.Domain.Bookings;

/* BookingsFactory.Java
 *  Entity for BookingsFactory
 *  Author: Yasmeen Nel (219250553)
 *  Date: 29 March 2022
 * */
public class BookingsFactory {
    //Create User Objects
    public static Bookings createBooking(String bookingID, String bookingTitle, String bookingDate, String bookingDescription,
                                         String bookingPackage){
        if (bookingTitle.equals("")|| bookingTitle == null)
            return null;
        if (bookingDate.equals("")|| bookingDate == null)
            return null;
        if (bookingDescription.equals("")|| bookingDescription == null)
            return null;
        if (bookingPackage.equals("")|| bookingPackage == null)
            return null;
        return new Bookings.Builder().setBookingID(bookingID)
                .setBookingTitle(bookingTitle)
                .setBookingDate(bookingDate)
                .setBookingDescription(bookingDescription)
                .setBookingPackage(bookingPackage)
                .build();

    }
}
