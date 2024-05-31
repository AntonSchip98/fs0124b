package it.schipani.dataLayer.entitys;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Device extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "devices_seq")
    @SequenceGenerator(name = "devices_seq", sequenceName = "devices_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeviceType type;

    @Enumerated(EnumType.STRING)
    private DeviceState state;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}