package za.ac.cput.service;

/*
Name: Yasmeen Nel
Student Number: 219250553
EventsService.java
Date : October '22
 */

import za.ac.cput.domain.Event;
import za.ac.cput.repository.EventRepository;

import java.util.List;
import java.util.Optional;

public class EventsService implements IEventsService{

    private final EventRepository repository;
    private static IEventsService service;


    private EventsService(){
        this.repository = EventRepository.getRepository();
    }

    public static IEventsService getService() {
        if (service == null)
            service = new EventsService();
        return service;

    }

    public Event save(Event event) {
        return this.repository.save(event);
    }


    public Optional<Event> read(String s) {
        return this.repository.read(s);
    }

    public void delete(Event event) {
        this.repository.delete(event);
    }


    public List<Event> getAll() {
        return this.repository.getAll();
    }
}