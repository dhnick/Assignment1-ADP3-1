package za.ac.cput.repository;
/*  IBookingsRepository.Java
 *  Entity for IBookingsRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.domain.Bookings;
import za.ac.cput.domain.Customer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IBookingsRepository extends IRepository<Bookings, String> {
    public List<Bookings> getAll();
    List<Customer> findByBookingsID(String bookingsID);
    boolean existsByBookingsID ( String bookingsID);
}
