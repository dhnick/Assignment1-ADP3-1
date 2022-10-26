package za.ac.cput.service;
/*
Name: Yasmeen Nel
Student Number: 219250553
IBookingsService.java
Date : October '22
 */
import za.ac.cput.domain.Bookings;
import za.ac.cput.domain.Customer;

import java.util.List;

public interface BookingsService extends IService<Bookings, String>{

    List<Bookings> findAll();
    boolean delete (String bookingsID);
    Bookings update(Bookings booking);
}
