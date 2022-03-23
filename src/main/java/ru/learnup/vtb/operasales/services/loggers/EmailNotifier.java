package ru.learnup.vtb.operasales.services.loggers;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.operasales.events.BuyEvent;
import ru.learnup.vtb.operasales.model.Ticket;

@Component
public class EmailNotifier implements ApplicationListener<BuyEvent> {

    @Override
    public void onApplicationEvent(BuyEvent event) {
        Ticket ev = (Ticket) event.getSource();
        System.out.println("Купили билет на мероприятие" + ev.getEventId());
    }
}
