package pl.sda.sapiens.ep.repository;

import org.springframework.stereotype.Repository;
import pl.sda.sapiens.ep.model.entity.EventEntity;

import java.time.LocalDateTime;
import java.util.*;

//@Repository
public class InMemoryEventRepository implements EventRepository{
    private Map<Long, EventEntity> events = new HashMap<>();

    public InMemoryEventRepository() {
        save(
                EventEntity.builder()
                        .title("Web application 2")
                        .description("Tworzenie applikacji REST, SOAP")
                        .start(LocalDateTime.of(2022,06,16,10,00,00))
                        .end(LocalDateTime.of(2022,06,18,10,00,00))
//                        .tags(List.of("programming", "session", "Java", "web"))
                        .build()
        );
        save(
                EventEntity.builder()
                        .title("Revision session")
                        .description("Powtórka materiału")
                        .start(LocalDateTime.of(2022,06,11,10,00,00))
                        .end(LocalDateTime.of(2022,06,12,10,00,00))
//                        .tags(List.of("programming", "session", "Java"))
                        .build()
        );
        save(
                EventEntity.builder()
                        .title("Project")
                        .description("Projekt")
                        .start(LocalDateTime.of(2022,06,23,10,00,00))
                        .end(LocalDateTime.of(2022,06,28,10,00,00))
//                        .tags(List.of("programming", "session", "Java", "project", "web"))
                        .build()
        );
    }

    @Override
    public void save(EventEntity entity) {
        long id = UUID.randomUUID().getLeastSignificantBits();
        entity.setId(id);
        events.put(id, entity);
    }

    @Override
    public List<EventEntity> findAllEventEntity() {
        return new ArrayList<>(events.values());
    }
}
