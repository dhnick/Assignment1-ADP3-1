package za.ac.cput.repository;
/*  IBookingsRepository.Java
 *  Entity for IBookingsRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Bookings;

import java.util.List;
import java.util.Set;
@Repository
public interface BookingsRepository extends JpaRepository<Bookings, String> {
//    public List<Bookings> getAll();
}
