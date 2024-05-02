package it.schipani.entity;


import jakarta.persistence.*;

import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

@Entity
@Table(name = "people")

public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", length = 80, nullable = false)
    private String name;
    @Column(name = "surname", length = 80, nullable = false)
    private String surname;
    @Column(name = "email", length = 80, nullable = false)
    private String email;
    @Column(name = "date", nullable = false)
    private Date birthDate;
    @Column(name = "sex", nullable = false)
    private Sex sex;
    @OneToMany(mappedBy = "people")
    private List<Participation> participations;


    public People() {
    }

    public People(Long id, String name, String surname, String email,
                  Date birthDate, Sex sex, List<Participation> participations) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthDate = birthDate;
        this.sex = sex;
        this.participations = participations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", People.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("surname='" + surname + "'")
                .add("email='" + email + "'")
                .add("birthDate=" + birthDate)
                .add("sex=" + sex)
                .add("ListParticipation=" + participations)
                .toString();
    }
}
