package it.schipani.dataLayer.repositories;

import it.schipani.dataLayer.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/* JpaRepository è un'interfaccia di Spring Data JPA che fornisce metodi per operazioni di
database comuni come salvare, trovare, cancellare e aggiornare entità.
 Spring Data JPA genererà automaticamente l'implementazione del repository, permettendoti
  di utilizzare metodi come:
  save(), findById(), findAll(), deleteById()*/
public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
