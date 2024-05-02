package it.schipani.entity;

import jakarta.persistence.*;

import java.util.StringJoiner;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "citta", length = 100, nullable = false)
    private String citta;

    public Location() {
    }

    public Location(Long id, String nome, String citta) {
        this.id = id;
        this.nome = nome;
        this.citta = citta;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Location.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nome='" + nome + "'")
                .add("citta='" + citta + "'")
                .toString();
    }
}
