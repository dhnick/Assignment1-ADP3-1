package za.ac.cput.controller;

/*
Name: Yasmeen Nel
Student Number: 219250553
EventsController.java
Date : October '22
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Event;
import za.ac.cput.factory.EventFactory;
import za.ac.cput.service.impl.EventsServiceImpl;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/events/")
@Slf4j
public class EventsController {

    @Autowired
    private EventsServiceImpl eventsService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Event create(@RequestBody Event events) {
        Event newEvent = EventFactory.createEvent(
                events.getEventID(),
                events.getEventName(),
                events.getRequestedDate(),
                events.getEventTheme());
        return eventsService.create(newEvent);
    }

  @RequestMapping("/read/{eventID}")
    public Event read(@PathVariable String eventID){
        return eventsService.read(eventID);
    }


    @PostMapping("/update")
    public Event update(@RequestBody Event events)
    {return eventsService.update(events);}


    @DeleteMapping("/delete/{eventID}")
    public boolean delete(@PathVariable String eventID) {
        return eventsService.delete(eventID);}


   @GetMapping("/findAll")
    public List<Event> findAll() {
        return eventsService.findAll();
    }

}

