package it.schipani.data;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 25, unique = true)
    private String uniqueCode;

    @Column(length = 80)
    private String description;

    @Enumerated(EnumType.STRING)
    private StationType stationType;

    @Column(name = "occupants")
    private int maxNumOccupants;

    @ManyToOne
    @JoinColumn(name = "building_id")
    private Building building;

    private boolean available = true;
}
