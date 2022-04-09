package za.ac.cput.Repository;
/*  IBookingsRepository.Java
 *  Entity for IBookingsRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.Domain.Bookings;

import java.util.Set;

public interface IBookingsRepository extends IRepository<Bookings, String> {
    public Set<Bookings> getAll();
}
