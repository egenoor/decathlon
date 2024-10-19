package ee.ege.decathlon.controller;

import ee.ege.decathlon.entity.Event;
import ee.ege.decathlon.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class EventController {
    private final String[] AVAILABLE_EVENTS = {
            "HUNDRED_METRES",
            "LONG_JUMP",
            "SHOT_PUT",
            "HIGH_JUMP",
            "FOUR_HUNDRED_METRES",
            "HUNDRED_TEN_METRE_HURDLE",
            "DISCUS_THROW",
            "JAVELIN_THROW",
            "THOUSAND_FIVE_HUNDRED_METRES"
    };

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/events")
    public String[] getEvents() {
        return AVAILABLE_EVENTS;
    }

//    @PostMapping("/event")
//    public List<Event> saveEvent(@RequestBody Event event) {
//
//    }

}
