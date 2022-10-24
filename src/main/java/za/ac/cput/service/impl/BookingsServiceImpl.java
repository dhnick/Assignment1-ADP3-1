package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Bookings;
import za.ac.cput.repository.BookingsRepository;
import za.ac.cput.service.BookingsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookingsServiceImpl implements BookingsService {

    private static  BookingsService service = null;

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public Bookings save(Bookings bookings) {
        return this.bookingsRepository.save(bookings);
    }

    @Override
    public Optional<Bookings> read(String bookingsID) {
        return this.bookingsRepository.findById(bookingsID);

    }

    @Override
    public Bookings update(Bookings bookings) {
        if (this.bookingsRepository.existsById(boo.getBookingsID())){
            return this.bookingsRepository.save(bookings);}
        return bookings;
    }


    @Override
    public void delete(Bookings bookings) {
        this.bookingsRepository.delete(bookings);

    }


    @Override
    public boolean delete(String bookingsID) {
        this.bookingsRepository.deleteById(bookingsID);
        if(this.bookingsRepository.existsById(bookingsID)){
            System.out.println("Bookings: "+bookingsID+" not Deleted");
            return false;
        }
        else{
            System.out.println("Booking Deleted");
            return true;
        }
    }


    // List of all Employees
    @Override
    public List<Bookings> findAll() {
        return this.bookingsRepository.findAll().stream().collect(Collectors.toList());
    }


}

