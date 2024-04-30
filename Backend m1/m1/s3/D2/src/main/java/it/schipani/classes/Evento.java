package it.schipani.classes;

import jakarta.persistence.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.StringJoiner;

@Entity
@Table(name = "gestioneeventi")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 80, nullable = false)
    private String title;

    @Column(name="date", nullable = false)
    private Date dataEvento;

    @Column(name = "description", length = 250, nullable = false)
    private String description;

    @Column(name = "max_partecipanti", nullable = false)
    private int maxNumberPartecipant;

    public Evento() {
    }

    public Evento(String title, Date dataEvento, String description, int maxNumberPartecipant) {
        this.title = title;
        this.dataEvento = dataEvento;
        this.description = description;
        this.maxNumberPartecipant = maxNumberPartecipant;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxNumberPartecipant() {
        return maxNumberPartecipant;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxNumberPartecipant(int maxNumberPartecipant) {
        this.maxNumberPartecipant = maxNumberPartecipant;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Evento.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .add("dataEvento=" + dataEvento)
                .add("description='" + description + "'")
                .add("maxNumberPartecipant=" + maxNumberPartecipant)
                .toString();
    }
}
