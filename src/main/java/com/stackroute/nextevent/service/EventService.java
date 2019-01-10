package com.stackroute.nextevent.service;

import com.stackroute.nextevent.exception.EventAlreadyExist;
import com.stackroute.nextevent.exception.EventNotFound;
import com.stackroute.nextevent.model.Event;

import java.util.List;

public interface EventService {

    Event saveEvent(Event event) throws EventAlreadyExist;
    boolean deleteEvent(long id) throws EventNotFound;
    Event updateEvent(Event event) throws EventNotFound;
    Event getEventById(long id) throws EventNotFound;
    List<Event> getAllEvent() throws EventNotFound;

}
