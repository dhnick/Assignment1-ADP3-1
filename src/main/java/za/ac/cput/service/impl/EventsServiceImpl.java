package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Event;
import za.ac.cput.repository.EventRepository;
import za.ac.cput.service.EventsService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventsServiceImpl implements EventsService {

    private static EventsService service = null;

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event save(Event events) {
        return this.eventRepository.save(events);
    }

    @Override
    public Optional<Event> read(String eventsID) {
        return this.eventRepository.findById(eventsID);

    }

    @Override
    public Event update(Event events) {
        if (this.eventRepository.existsById(boo.getEventsID())){
            return this.eventRepository.save(events);}
        return events;
    }


    @Override
    public void delete(Event events) {
        this.eventRepository.delete(events);

    }


    @Override
    public boolean delete(String eventsID) {
        this.eventRepository.deleteById(eventsID);
        if(this.eventRepository.existsById(eventsID)){
            System.out.println("Event: "+eventsID+" not Deleted");
            return false;
        }
        else{
            System.out.println("Event Deleted");
            return true;
        }
    }


    // List of all Employees
    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll().stream().collect(Collectors.toList());
    }


}
