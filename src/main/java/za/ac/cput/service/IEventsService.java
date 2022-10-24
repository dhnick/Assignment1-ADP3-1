package za.ac.cput.service;
/*
Name: Yasmeen Nel
Student Number: 219250553
IEventsService.java
Date : October '22
 */

import za.ac.cput.domain.Event;
import java.util.List;

public interface IEventsService extends IService<Event, String>{

    List<Event> getAll();
}
