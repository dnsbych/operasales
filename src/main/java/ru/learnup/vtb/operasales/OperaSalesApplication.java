package ru.learnup.vtb.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;
import ru.learnup.vtb.operasales.services.EventService;
import ru.learnup.vtb.operasales.services.TicketService;

import java.util.List;

@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext ctx = SpringApplication.run(OperaSalesApplication.class, args);


       // ctx.getBean(TicketService.class).byTicket(new TicketEntity(null, 100, 1, null));
        //ctx.getBean(TicketService.class).returnTicket(2L);

//        List<EventEntity> list = ctx.getBean(EventService.class).getList();
//        System.out.println(list);


        EventEntity e = ctx.getBean(EventService.class).getEventById(1L);
        System.out.println(e);

    }

}
