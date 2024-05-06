package it.schipani.entity;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "participation")
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "people_id", nullable = false)
    private People people;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Evento event;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ParticipationState state;


    public Participation() {
    }

    public Participation( People people, Evento event, ParticipationState state) {
        this.people = people;
        this.event = event;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public People getPeople() {
        return people;
    }

    public Evento getEvent() {
        return event;
    }

    public ParticipationState getState() {
        return state;
    }

    public void setState(ParticipationState state) {
        this.state = state;
    }

    public void setEvent(Evento event) {
        this.event = event;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Participation.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("people=" + people)
                .add("event=" + event)
                .add("state=" + state)
                .toString();
    }
}
