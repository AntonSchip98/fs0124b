package it.schipani.dataLayer.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Entity
@Table(name = "users")
@Builder(setterPrefix = "with")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends EntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @SequenceGenerator(name = "users_seq", sequenceName = "users_seq")
    private long id;

    @Column(length = 125, unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String username;

    @Column(length = 125, nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private final List<RoleEntity> roles = new ArrayList<>();

}
