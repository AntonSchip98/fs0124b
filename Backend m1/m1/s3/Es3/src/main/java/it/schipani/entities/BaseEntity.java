package it.schipani.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;


/*BaseEntity è una entità che ha caratteristiche comuni ad altre entità,
 ma non deve persitere su nessuna tabella*/
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public BaseEntity() {
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

}
