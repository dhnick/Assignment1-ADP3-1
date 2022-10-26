package za.ac.cput.service.impl;
/*  BookingsServiceImp.Java
 *  Entity for BookingsServiceImp
 *  Author: Yasmeen Nel (219250553)
 *  Date: October 2022
 * */
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Bookings;
import za.ac.cput.repository.BookingsRepository;
import za.ac.cput.service.BookingsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingsServiceImp implements BookingsService {
    private static BookingsService service = null;

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Bookings create(Bookings bookings) {
        return this.bookingsRepository.save(bookings);
    }

    @Override
    public Bookings read(String BookingID) {
        return this.bookingsRepository.findById(BookingID).orElse(null);
    }

    @Override
    public Bookings update(Bookings bookings) {
        if (this.bookingsRepository.existsById(bookings.getBookingID())){
            return this.bookingsRepository.save(bookings);}
        return bookings;
    }

    @Override
    public boolean delete(String BookingID) {
        this.bookingsRepository.deleteById(BookingID);
        if(this.bookingsRepository.existsById(BookingID)){
            System.out.println("Booking: "+ BookingID + " not Deleted");
            return false;
        }
        else{
            System.out.println("Booking Deleted");
            return true;
        }
    }

    @Override
    public List<Bookings> findAll() {
        return this.bookingsRepository.findAll().stream().collect(Collectors.toList());
    }

}
