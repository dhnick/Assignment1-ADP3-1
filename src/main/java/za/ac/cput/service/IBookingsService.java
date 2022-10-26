package za.ac.cput.service;
/*
Name: Yasmeen Nel
Student Number: 219250553
IBookingsService.java
Date : October '22
 */
import za.ac.cput.domain.Bookings;

import java.util.List;

public interface IBookingsService extends IService<Bookings, String>{

    List<Bookings> getAll();
}
