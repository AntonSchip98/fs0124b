package it.schipani.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Table(name = "attendances")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceEntity extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "attendance_seq")
    @SequenceGenerator(name = "attendance_seq", sequenceName = "attendance_seq")
    private long id;

    @ManyToOne
    private UserEntity user;

    @ManyToOne
    private EventEntity event;

    @Enumerated(EnumType.ORDINAL)
    private Status status;
}
