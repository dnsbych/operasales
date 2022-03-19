package ru.learnup.vtb.operasales.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tickets")
@Proxy(lazy=false)
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "tickets_seq", sequenceName = "tickets_seq")
    private Long id;

    @Column(name = "price")
    private int price;


    @JoinColumn(name = "event_id")
    @ManyToOne
    private EventEntity event;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "TicketEntity{" +
                "id=" + id +
                ", price=" + price +
                '}';
    }

}
