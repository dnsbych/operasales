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
        SpringApplication.run(OperaSalesApplication.class, args);
    }

}
