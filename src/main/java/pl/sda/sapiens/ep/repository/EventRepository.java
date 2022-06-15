package pl.sda.sapiens.ep.repository;

import pl.sda.sapiens.ep.model.entity.EventEntity;

import java.util.List;

public interface EventRepository {
    void save(EventEntity entity);
    List<EventEntity> findAllEventEntity();
}
