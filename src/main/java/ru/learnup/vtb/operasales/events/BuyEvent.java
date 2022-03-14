package ru.learnup.vtb.operasales.events;

import org.springframework.context.ApplicationEvent;
import ru.learnup.vtb.operasales.model.Ticket;

public class BuyEvent extends ApplicationEvent {


    public BuyEvent(Ticket source) {
        super(source);
    }
}
