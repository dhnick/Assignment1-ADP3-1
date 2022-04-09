package za.ac.cput.Repository;
/*  BookingsRepository.Java
 *  Entity for BookingsRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.Domain.Bookings;

import java.util.HashSet;
import java.util.Set;

public class BookingsRepository implements IBookingsRepository{
    private static BookingsRepository repository = null;
    private Set<Bookings> bookingsDB = null;

    private BookingsRepository(){
        bookingsDB = new HashSet<Bookings>();
    }

    public static BookingsRepository getRepository(){
        if(repository == null){
            repository= new BookingsRepository();
        }
        return repository;
    }

    @Override
    public Bookings create(Bookings bookings) {
        boolean success = bookingsDB.add(bookings);
        if (!success)
            return null;
        return bookings;
    }

    @Override
    public Bookings read(String bookingID) {
        for (Bookings book : bookingsDB)
            if (book.getBookingID().equals(bookingID))
                return book;
        return null;
    }

    @Override
    public Bookings update(Bookings bookings) {
        Bookings oldBookings = read(bookings.getBookingID());
        if(oldBookings != null){
            bookingsDB.remove(oldBookings);
            bookingsDB.add(bookings);
            return bookings;
        }
        return null;
    }

    @Override
    public void delete(String bookingID) {
        Bookings deleteBookings = read(bookingID);
        if (deleteBookings == null) {
            System.out.println("Booking is null.");
        }
        bookingsDB.remove(deleteBookings);
        System.out.println("Booking has been  removed.");

    }

    @Override
    public Set<Bookings> getAll() {
        return bookingsDB;
    }
}
