package com.devin.ead.springagrisl.controller;

import com.devin.ead.springagrisl.model.Event;
import com.devin.ead.springagrisl.model.Supplier;
import com.devin.ead.springagrisl.service.EventService;
import com.devin.ead.springagrisl.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    // display list of events
    @GetMapping("/events")
    public String viewEventPage(Model model) {
        model.addAttribute("listEvents", eventService.getAllEvents());
        return "event";
    }

    @GetMapping("/showNewEventForm")
    public String showNewEventForm(Model model) {

        // create model attribute to bind form data
        Event event = new Event();
        model.addAttribute("event", event);
        return "new_event";
    }

    @PostMapping("/saveEvent")
    public String saveEvent (@ModelAttribute("event") Event event) {
        // save events to database
        eventService.saveEvent(event);
        return "redirect:/events";
    }

    @GetMapping("/showEventFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

        // get event from the service
        Event event = eventService.getEventById(id);

        // set event as a model attribute to pre-populate the form
        model.addAttribute("event", event);

        return "update_event";
    }

    @GetMapping("/deleteEvent/{id}")
    public String deleteEvent(@PathVariable(value = "id") long id) {

        // call delete event method
        this.eventService.deleteEventById(id);
        return "redirect:/events";

    }
}
