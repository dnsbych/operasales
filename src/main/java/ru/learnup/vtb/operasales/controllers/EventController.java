package ru.learnup.vtb.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.vtb.operasales.controllers.dto.EventDto;
import ru.learnup.vtb.operasales.mappers.Mapper;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.model.Ticket;
import ru.learnup.vtb.operasales.services.EventService;
import ru.learnup.vtb.operasales.services.TicketService;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;
    private TicketService ticketService;
    private Mapper mapper;

    @Autowired
    public EventController(EventService eventService, TicketService ticketService, Mapper mapper) {

        this.eventService = eventService;
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @GetMapping
    public Collection<EventDto> getEvents(){
        final List<Event> events = eventService.getList();
        return events.stream()
                .map(mapper::toDto)
                .collect(toList());
    }

    @GetMapping("/{id}")
    public EventDto get(@PathVariable("id") long id){
        final Event event = eventService.getEventById(id);
        final List<Ticket> tickets = ticketService.getETikets(event.getId());
        event.setTickets(tickets);

        return mapper.toDto(event);
    }

    @PostMapping
    public Long create(@RequestBody EventDto eventDto){
        Event event = mapper.toDomain(eventDto);
        return eventService.addEvent(mapper.toEntity(event));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody EventDto eventDto){
        Event event = mapper.toDomain(eventDto);
        eventService.editEvent(mapper.toEntity(event));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        eventService.deleteEvent(id);
    }


}
