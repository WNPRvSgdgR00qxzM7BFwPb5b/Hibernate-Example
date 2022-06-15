package pl.sda.sapiens.ep.model.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Event {
    private long id;
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;
    private List<String> tags;
    private User publisher;
}
