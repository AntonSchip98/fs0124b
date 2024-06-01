package it.schipani.dataLayer.repositories;

import it.schipani.dataLayer.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findOneByName(String roleName);
}
