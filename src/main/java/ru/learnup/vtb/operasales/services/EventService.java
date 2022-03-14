package ru.learnup.vtb.operasales.services;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;
import ru.learnup.vtb.operasales.repository.interfaces.EventRepository;
import ru.learnup.vtb.operasales.services.interfaces.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;


@Service
public class EventService implements ApplicationContextAware {

    private Logger logger;
    private ApplicationContext ctx;
    private EventRepository repository;

    @Autowired
    public EventService(Logger logger, EventRepository repository) {
        this.logger = logger;
        this.repository = repository;
    }


    public void addEvent(EventEntity e) {
        repository.save(e);
    }

    public EventEntity getEventById(Long id)
    {
        return repository.getById(id);
    }


    public void editEvent(EventEntity e) {
        repository.save(e);
    }

    public void deleteEvent(Long id) {
        repository.deleteById(id);
    }

    public List<EventEntity> getList() {

        return repository.findAll();
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
