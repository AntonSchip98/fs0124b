package it.schipani.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "events")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity extends EntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_seq")
    @SequenceGenerator(name = "events_seq", sequenceName = "events_seq")
    private long id;

    @Column(length = 80, nullable = false)
    private String eventTitle;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime publishedAt;

    @Column(length = 255, nullable = true)
    private String eventDescription;

    @Enumerated(EnumType.ORDINAL)
    private EventType type;

    @Column(name = "max_attendance")
    private int maxAttendance;

    @Column(name = "location")
    private String location;
}

