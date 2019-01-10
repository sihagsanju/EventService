package com.stackroute.nextevent.service;

import com.stackroute.nextevent.exception.EventAlreadyExist;
import com.stackroute.nextevent.exception.EventNotFound;
import com.stackroute.nextevent.model.Event;
import com.stackroute.nextevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
     private EventRepository eventRepository;

     @Autowired
     EventServiceImpl(EventRepository eventRepository)
     {
         this.eventRepository = eventRepository;
     }

    @Override
    public Event saveEvent(Event event) throws EventAlreadyExist {
        //return null;
        Event savedEvent=eventRepository.findByEventId(event.getId());
        if(savedEvent!=null)
        {
            throw new EventAlreadyExist("Event already Exists");
        }
        else
        {
           return eventRepository.save(event);
        }
    }

    @Override
    public boolean deleteEvent(long id) throws EventNotFound {
        //return false;
        Event event = eventRepository.findByEventId(id);
        if(event!=null)
        {
            eventRepository.delete(event);
            return true;
        }
        else {
            throw new EventNotFound("Event not found with this id");
        }

    }

    @Override
    public Event updateEvent(Event event) throws EventNotFound {
        //return null;
        Event eventToBeUpdated = eventRepository.findByEventId(event.getId());
        if(event!=null)
        {
            eventToBeUpdated.setCreated(event.getCreated());
            eventToBeUpdated.setDescription(event.getDescription());
            eventToBeUpdated.setEnd(event.getEnd());
            eventToBeUpdated.setStart(event.getStart());
            eventToBeUpdated.setImageUrl(event.getImageUrl());
            eventToBeUpdated.setName(event.getName());
         return   eventRepository.save(eventToBeUpdated);

        }
        else {
            throw new EventNotFound("Event not found with this id");
        }
    }

    @Override
    public Event getEventById(long id) throws EventNotFound {
        //return null;
        Event event = eventRepository.findByEventId(id);
        if(event!=null)
        {
            return  eventRepository.findByEventId(id);

        }
        else {
            throw new EventNotFound("Event not found with this id");
        }
    }

    @Override
    public List<Event> getAllEvent() throws EventNotFound {
        //return null;
        return eventRepository.findAll();

    }
}
