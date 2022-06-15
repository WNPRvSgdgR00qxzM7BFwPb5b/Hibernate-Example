package pl.sda.sapiens.ep.model.view;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventForm {
    private String title;
    private String description;
    private String start;
    private String end;
    private List<String> tags = new ArrayList<>();
}
