package com.devin.ead.springagrisl.service;


import com.devin.ead.springagrisl.model.Event;
import com.devin.ead.springagrisl.repositary.EventRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepositary eventRepositary;

    public List<Event> getAllEvents() {
        return eventRepositary.findAll();
    }

    public void saveEvent(Event event) {
        this.eventRepositary.save(event);
    }

    public Event getEventById(long id) {
        Optional<Event> optional = eventRepositary.findById(id);
        Event event = null;
        if (optional.isPresent()) {
            event = optional.get();
        } else {
            throw new RuntimeException(" Event not found for id :: " + id);
        }
        return event;
    }

    public void deleteEventById(long id) {
        this.eventRepositary.deleteById(id);
    }
}
