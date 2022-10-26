package za.ac.cput.controller;

/*
Name: Yasmeen Nel
Student Number: 219250553
BookingsController.java
Date : October '22
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Bookings;
import za.ac.cput.factory.BookingsFactory;
import za.ac.cput.service.impl.BookingsServiceImp;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/bookings/")
@Slf4j
public class BookingsController{

    @Autowired
    private BookingsServiceImp bookingsService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Bookings create(@RequestBody Bookings bookings) {
        Bookings newBooking = BookingsFactory.createBooking(
                bookings.getBookingID(),
                bookings.getBookingTitle(),
                bookings.getBookingDate(),
                bookings.getBookingDescription(),
                bookings.getBookingPackage());
        return bookingsService.save(bookings);
    }

    @RequestMapping("/read/{bookingID}")
    public Optional<Bookings> read(@PathVariable String bookingID){
        return bookingsService.read(bookingID);
    }


    @PostMapping("/update")
    public Bookings update(@RequestBody Bookings bookings)
    {return bookingsService.update(bookings);}


    @DeleteMapping("/delete/{bookingID}")
    public boolean delete(@PathVariable String bookingID) {
        return bookingsService.delete(bookingID);}


    @GetMapping("/findAll")
    public List<Bookings> findAll() {
        return bookingsService.findAll();
    }

}

