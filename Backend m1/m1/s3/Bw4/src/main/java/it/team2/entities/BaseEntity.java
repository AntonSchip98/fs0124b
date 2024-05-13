package it.team2.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue
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
