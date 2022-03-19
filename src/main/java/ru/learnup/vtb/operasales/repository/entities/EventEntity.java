package ru.learnup.vtb.operasales.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.hibernate.mapping.Set;
import ru.learnup.vtb.operasales.model.Ticket;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "events")
@Proxy(lazy=false)
public class EventEntity {

    public EventEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_seq")
    @SequenceGenerator(name = "events_seq", sequenceName = "events_seq")
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName(){
        return name;
    }

    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER)
    private Collection<TicketEntity> tickets;


    @Column(name = "name")
    private String name;


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder(String.format("%s (%d)\n", name, id));

        for (TicketEntity ticket: tickets) {
            sb.append(ticket).append("\n");
        }

        return sb.toString();
    }
}
