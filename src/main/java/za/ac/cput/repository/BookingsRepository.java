package za.ac.cput.repository;
/*  BookingsRepository.Java
 *  Entity for BookingsRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.domain.Bookings;

import java.util.*;

public class BookingsRepository{
    private static BookingsRepository repository ;
    private List<Bookings> bookingsDB ;

    private BookingsRepository(){
        this.bookingsDB = new ArrayList<>();
    }

    public static BookingsRepository getRepository(){
        if(repository == null){
            repository= new BookingsRepository();
        }
        return repository;
    }

    public Bookings save(Bookings bookings) {
        Optional<Bookings> read = read(bookings.getBookingID());
        if(read.isPresent()){
            delete(read.get());
        }
        this.bookingsDB.add(bookings);
        return bookings;
    }


    public Bookings read(String bookingID) {
        for (Bookings book : bookingsDB)
            if (book.getBookingID().equals(bookingID))
                return book;
        return null;
    }

    public Bookings update(Bookings bookings) {
        Bookings oldBookings = read(bookings.getBookingID());
        if(oldBookings != null){
            bookingsDB.remove(oldBookings);
            bookingsDB.add(bookings);
            return bookings;
        }
        return null;
    }


    public void delete(String bookingID) {
        Bookings deleteBookings = read(bookingID);
        if (deleteBookings == null) {
            System.out.println("Booking is null.");
        }
        bookingsDB.remove(deleteBookings);
        System.out.println("Booking has been  removed.");

    }


    public List<Bookings> getAll() {
        return bookingsDB;
    }
}
