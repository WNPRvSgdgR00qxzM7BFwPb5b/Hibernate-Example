package pl.sda.sapiens.ep.repository;

import pl.sda.sapiens.ep.model.entity.TagEntity;

public interface TagRepository {
    TagEntity saveIfNotPresent(String tag);
}
