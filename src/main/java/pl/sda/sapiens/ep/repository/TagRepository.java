package pl.sda.sapiens.ep.repository;

import pl.sda.sapiens.ep.model.entity.EventEntity;

public interface TagRepository {
    boolean saveIfNotPresent(String tag, EventEntity event);
}
