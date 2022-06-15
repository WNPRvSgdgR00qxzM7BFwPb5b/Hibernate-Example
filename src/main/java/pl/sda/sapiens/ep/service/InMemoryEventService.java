package pl.sda.sapiens.ep.service;

import org.springframework.stereotype.Service;
import pl.sda.sapiens.ep.model.entity.EventEntity;
import pl.sda.sapiens.ep.model.entity.TagEntity;
import pl.sda.sapiens.ep.model.view.EventForm;
import pl.sda.sapiens.ep.repository.EventRepository;
import pl.sda.sapiens.ep.repository.TagRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class InMemoryEventService implements EventService {

    private final EventRepository eventRepository;
    private final TagRepository tagRepository;
    private final TimeProvider timeProvider;

    public InMemoryEventService(
            EventRepository eventRepository,
            TagRepository tagRepository,
            TimeProvider timeProvider) {
        this.eventRepository = eventRepository;
        this.tagRepository = tagRepository;
        this.timeProvider = timeProvider;
    }


    @Override
    public void saveEvent(EventForm eventForm) {

        //TODO zdefiniować mapper z EventForm na Event
        //TODO zdefiniwać mapper z Event na EventEntity

        // zamieniamy stringi z formularza na kolekcję TagEntity zapisanych w bazie
        Set<TagEntity> eventTags = eventForm.getTags().stream()
                .map(tagRepository::saveIfNotPresent)
                .collect(Collectors.toSet());

//        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection") // tylko do celów edukacyjnych, to samo co eventTags
//        Set<TagEntity> alternativeTags = new HashSet<>();
//        for (String tagName : eventForm.getTags()) {
//            TagEntity tag = tagRepository.saveIfNotPresent(tagName);
//            alternativeTags.add(tag);
//        }

        final EventEntity entity = EventEntity.builder()
                .title(eventForm.getTitle())
                .description(eventForm.getDescription())
                .start(LocalDateTime.parse(eventForm.getStart(), DateTimeFormatter.ISO_DATE_TIME))
                .end(LocalDateTime.parse(eventForm.getEnd(), DateTimeFormatter.ISO_DATE_TIME))
                .tags(eventTags)
                .build();
        eventRepository.save(entity);
    }

    @Override
    public List<EventEntity> findCurrentEvents() {
        return eventRepository
                .findAllEventEntity()
                .stream()
                .filter(event -> event.getStart().isAfter(timeProvider.getCurrentDateTime()))
                .sorted(Comparator.comparing(EventEntity::getStart))
                .collect(Collectors.toList());
    }
}
