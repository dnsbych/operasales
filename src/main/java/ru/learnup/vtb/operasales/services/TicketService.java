package ru.learnup.vtb.operasales.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;
import ru.learnup.vtb.operasales.repository.interfaces.TicketRepository;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

@Service
@Data
@AllArgsConstructor
public class TicketService implements ApplicationContextAware {

    Logger logger;
    ApplicationContext ctx;
    TicketRepository repository;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {IOException.class, FileNotFoundException.class, EOFException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public void byTicket(TicketEntity t) {
        repository.save(t);
    }

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {IOException.class, FileNotFoundException.class, EOFException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public void returnTicket(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }
}
