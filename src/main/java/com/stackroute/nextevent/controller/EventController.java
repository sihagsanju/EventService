package com.stackroute.nextevent.controller;

import com.stackroute.nextevent.exception.EventAlreadyExist;
import com.stackroute.nextevent.exception.EventNotFound;
import com.stackroute.nextevent.model.Event;
import com.stackroute.nextevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    private ResponseEntity responseEntity;
    private EventService eventService;

    @Autowired
    private EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("getAllEvent")
    public ResponseEntity<?> getAllEvent() {
        try {
            responseEntity = new ResponseEntity(eventService.getAllEvent(), HttpStatus.OK);
        } catch (EventNotFound eventNotFound) {
            eventNotFound.printStackTrace();
            responseEntity = new ResponseEntity("Error while getting events" + eventNotFound.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        }
        catch (Exception exception)
        {
            responseEntity = new ResponseEntity("errro",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @PostMapping("saveEvent")
    public ResponseEntity<?> saveEvent(@RequestBody Event event) {
        try {
            eventService.saveEvent(event);
            responseEntity = new ResponseEntity(event, HttpStatus.CREATED);

        } catch (EventAlreadyExist eventAlreadyExist) {
            eventAlreadyExist.printStackTrace();
            responseEntity = new ResponseEntity("Event already exists", HttpStatus.CONFLICT);
        } catch (Exception e) {

            responseEntity = new ResponseEntity("error ", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("deleteEvent/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") Long id) {
        try {
            eventService.deleteEvent(id);
            responseEntity = new ResponseEntity("event deleted successfully", HttpStatus.OK);

        } catch (EventNotFound eventNotFound) {
            eventNotFound.printStackTrace();
            responseEntity = new ResponseEntity("event not found", HttpStatus.NOT_FOUND);

        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;

    }


    @PutMapping("updateEvent")
    public ResponseEntity<?> updateEvent(@RequestBody Event event) {
        try {
            eventService.updateEvent(event);
            responseEntity = new ResponseEntity("event updated successfully", HttpStatus.OK);

        } catch (EventNotFound eventNotFound) {
            eventNotFound.printStackTrace();
            responseEntity = new ResponseEntity("Event not found", HttpStatus.NOT_FOUND);
        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("getEventbyId/{id}")
    public ResponseEntity<?> getEventById(@PathVariable("id") long id) {
        try {
            responseEntity = new ResponseEntity(eventService.getEventById(id), HttpStatus.OK);
        } catch (EventNotFound eventNotFound) {
            eventNotFound.printStackTrace();
            responseEntity = new ResponseEntity("Error while getting events" + eventNotFound.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (Exception exception) {
            responseEntity = new ResponseEntity(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }
}































