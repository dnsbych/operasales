package ru.learnup.vtb.operasales.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.learnup.vtb.operasales.repository.entities.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long> {
}
