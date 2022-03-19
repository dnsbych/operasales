package ru.learnup.vtb.operasales.mappers;

import ru.learnup.vtb.operasales.controllers.dto.EventDto;
import ru.learnup.vtb.operasales.controllers.dto.TicketDto;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.model.Ticket;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    EventDto toDto(Event event);
    Event toDomain(EventDto eventDto);

    EventEntity toEntity(Event event);
    Event toDomain(EventEntity eventEntity);

    TicketDto toDto(Ticket ticket);
    Ticket toDomain(TicketDto ticketDto);

    TicketEntity toEntity(Ticket ticket);
    Ticket toDomain(TicketEntity ticketEntity);

}
