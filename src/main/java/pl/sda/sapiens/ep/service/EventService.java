package pl.sda.sapiens.ep.service;

import pl.sda.sapiens.ep.model.entity.EventEntity;
import pl.sda.sapiens.ep.model.view.EventForm;

import java.util.List;

public interface EventService {
    void saveEvent(EventForm eventForm);
    List<EventEntity> findCurrentEvents();
}
