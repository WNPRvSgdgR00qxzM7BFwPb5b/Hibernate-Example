package pl.sda.sapiens.ep.model.entity;

import lombok.*;
import pl.sda.sapiens.ep.model.domain.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "event")
@Table(name = "events")
public class EventEntity {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDateTime start;
    @Column(nullable = false)
    private LocalDateTime end;

    @ManyToMany
    @JoinTable(name = "tags_events",
            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id", referencedColumnName = "id"))
    private List<TagEntity> tags;

}
