package it.team2.entities;

import jakarta.persistence.*;
import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt = new Date();

    public long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
