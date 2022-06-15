package pl.sda.sapiens.ep.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "tag")
@Table(name = "tags", indexes = {@Index(columnList = "name")})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String name;
    @ManyToMany(mappedBy = "tags")
    private Set<EventEntity> events;

}
