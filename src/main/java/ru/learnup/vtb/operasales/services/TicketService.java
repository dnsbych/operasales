package ru.learnup.vtb.operasales.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.model.Ticket;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;
import ru.learnup.vtb.operasales.repository.interfaces.TicketRepository;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class TicketService implements ApplicationContextAware {

    Logger logger;
    ApplicationContext ctx;
    TicketRepository repository;

    public void byTicket(TicketEntity t) {
        repository.save(t);
    }

    public void returnTicket(Long id) {
        repository.deleteById(id);
    }

    public List<Ticket> getETikets(Long eventId){
        return toDomain(repository.getTicketEntitiesByEvent_Id(eventId));
    }


    private List<Ticket> toDomain(List<TicketEntity> entities){
        return entities.stream()
                .map(TicketService::toDomain).collect(Collectors.toList());
    }

    private static Ticket toDomain(TicketEntity ticket){
        return new Ticket(ticket.getId(), ticket.getPrice(), ticket.getEvent().getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
