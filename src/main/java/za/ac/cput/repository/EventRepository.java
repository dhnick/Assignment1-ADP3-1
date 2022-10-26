package za.ac.cput.repository;
/*  IEventRepository.Java
 *  Entity for IEventRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, String> {
//        public Set<Event> getAll();
}
