package ru.learnup.vtb.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.learnup.vtb.operasales.controllers.dto.EventDto;
import ru.learnup.vtb.operasales.controllers.dto.TicketDto;
import ru.learnup.vtb.operasales.mappers.Mapper;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.model.Ticket;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;
import ru.learnup.vtb.operasales.services.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private TicketService ticketService;
    private Mapper mapper;

    @Autowired
    public TicketController(TicketService ticketService, Mapper mapper) {
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @PostMapping
    public Long create(@RequestBody TicketDto ticketDto){
        Ticket ticket = mapper.toDomain(ticketDto);
        TicketEntity ticketEntity = mapper.toEntity(ticket);
        return ticketService.byTicket(ticketEntity);
    }
}
