package ru.learnup.vtb.operasales.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.learnup.vtb.operasales.model.Event;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;
import ru.learnup.vtb.operasales.repository.interfaces.EventRepository;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.LockModeType;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class EventService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private EventRepository repository;
    private TransactionTemplate txTemplate;

    @Autowired
    public EventService(Logger logger, EventRepository repository, TransactionTemplate txTemplate) {
        this.logger = logger;
        this.repository = repository;
        this.txTemplate = txTemplate;
    }


    public void addEvent(EventEntity e) {

        txTemplate.executeWithoutResult((status)->{
            try{
                repository.save(e);
            }catch (Exception err){
                System.err.println(err);
                status.setRollbackOnly();
            }
        });

        repository.save(e);
    }

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    public Event getEventById(Long id)
    {
        try {
            return toDomain(repository.getById(id));
        }catch (Exception err){
            System.err.println(err.getMessage());
        }

        return null;
    }


    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.DEFAULT,
            timeout = 3,
            rollbackFor = {IOException.class, FileNotFoundException.class, EOFException.class},
            noRollbackFor = {RuntimeException.class}
    )
    public void editEvent(EventEntity e) {
        try {
            repository.save(e);
            //Thread.sleep(5000);
            //throw new FileNotFoundException("Тестовая ошибка!");
        }catch (Exception err){
            System.err.println(err.getMessage());
        }
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }

    public List<Event> getList() {
        return toDomain(repository.findAllOrderedById());
    }

    private List<Event> toDomain(List<EventEntity> entities){
        return entities.stream()
                .map(EventService::toDomain).collect(Collectors.toList());
    }

    private static Event toDomain(EventEntity entity){
        return new Event(entity.getId(), entity.getName());
    }


    @PostConstruct
    public void init() {
//        logger.print("Создан сервис " + this.getClass().getSimpleName());
    }

    @PreDestroy
    public void destroy() {
//        logger.print("Завершен сервис " + this.getClass().getSimpleName());
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }
}
