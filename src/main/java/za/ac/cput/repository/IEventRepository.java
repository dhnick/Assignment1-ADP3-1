package za.ac.cput.repository;
/*  IEventRepository.Java
 *  Entity for IEventRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.domain.Event;

import java.util.Set;

public interface IEventRepository extends IRepository<Event, String> {
        public Set<Event> getAll();
}
