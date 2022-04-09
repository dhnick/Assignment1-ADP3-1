package za.ac.cput.Repository;
/*  EventRepository.Java
 *  Entity for EventRepository
 *  Author: Yasmeen Nel (219250553)
 *  Date: 7 April 2022
 * */
import za.ac.cput.Domain.Event;

import java.util.HashSet;
import java.util.Set;

public class EventRepository implements IEventRepository {
    private static EventRepository repository = null;
    private Set<Event> eventDB = null;

    private EventRepository(){
        eventDB = new HashSet<Event>();
    }

    public static EventRepository getRepository(){
        if(repository == null){
            repository= new EventRepository();
        }
        return repository;
    }

    @Override
    public Event create(Event event) {
        boolean success = eventDB.add(event);
        if (!success)
            return null;
        return event;
    }

    @Override
    public Event read(String eventID) {
        for (Event eve : eventDB)
            if (eve.getEventID().equals(eventID))
             return eve;
        return null;
    }

    @Override
    public Event update(Event event) {
        Event oldEvent = read(event.getEventID());
        if(oldEvent != null){
            eventDB.remove(oldEvent);
            eventDB.add(event);
            return event;
        }
        return null;
    }

    @Override
    public void delete(String eventID) {
        Event deleteEvent = read(eventID);
        if (deleteEvent == null) {
            System.out.println("Event is null.");
        }
        eventDB.remove(deleteEvent);
        System.out.println("Event has been  removed.");

    }

    @Override
    public Set<Event> getAll() {
        return eventDB;
    }

}

