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
    public Event create(Event event) {
        return this.eventRepository.save(event);
    }

    @Override
    public Event read(String EventID) {
        return this.eventRepository.findById(EventID).orElse(null);
    }

    @Override
    public Event update(Event event) {
        if (this.eventRepository.existsById(event.getEventID())){
            return this.eventRepository.save(event);}
        return event;
    }

    @Override
    public boolean delete(String EventID) {
        this.eventRepository.deleteById(EventID);
        if(this.eventRepository.existsById(EventID)){
            System.out.println("Event: "+ EventID + " not Deleted");
            return false;
        }
        else{
            System.out.println("Event Deleted");
            return true;
        }
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll().stream().collect(Collectors.toList());
    }

}