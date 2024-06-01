package it.schipani.businessLayer;

import it.schipani.dataLayer.entities.RoleEntity;

public interface RoleService {
    RoleEntity save(String roleName);
}
