package za.ac.cput.service;
/*
Name: Yasmeen Nel
Student Number: 219250553
IEventsService.java
Date : October '22
 */

import za.ac.cput.domain.Event;
import java.util.List;

public interface EventsService extends IService<Event, String>{

    Event update(Event event);

    boolean delete(String EventID);

    List<Event> findAll();
}
