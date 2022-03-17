package ru.learnup.vtb.operasales.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.learnup.vtb.operasales.repository.entities.EventEntity;

import java.util.List;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

    void deleteById(Long id);

    EventEntity getById(Long id);

    @Query("From EventEntity e order by e.id")
    List<EventEntity> findAllOrderedById();

}
