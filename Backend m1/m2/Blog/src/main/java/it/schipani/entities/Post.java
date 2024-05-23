package it.schipani.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder(setterPrefix = "with")
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(name = "Category", length = 80)
    private String category;

    @Column(name = "Title")
    private String title;

    @Column(name = "Cover", length = 80)
    private String cover;

    @Column(name = "Content", length = 2048)
    private String content;

    @Column(name = "Time")
    private double lectureTime;

    @ManyToOne
    private User User;
}
