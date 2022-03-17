package ru.learnup.vtb.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.model.Ticket;
import ru.learnup.vtb.operasales.services.EventService;
import ru.learnup.vtb.operasales.services.TicketService;

import java.util.List;

@Controller
@RequestMapping(value = "/events", method = RequestMethod.GET)
public class EventController {

    private EventService eventService;
    private TicketService ticketService;

    @Autowired
    public EventController(EventService eventService, TicketService ticketService) {

        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String showEvents(Model model){
        final List<Event> events = eventService.getList();
        model.addAttribute("events", events);
        return "events";
    }

    @GetMapping("/{id}")
    public String viewevent(@PathVariable("id") long id, Model model){
        final Event event = eventService.getEventById(id);
        model.addAttribute("event", event);

        final List<Ticket> tickets = ticketService.getETikets(event.getId());
        model.addAttribute("tickets", tickets);

        return "viewevent";
    }

}
