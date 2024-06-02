package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.services.RoleService;
import it.schipani.dataLayer.entities.RoleEntity;
import it.schipani.dataLayer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roles;

    @Override
    public RoleEntity save(String roleName) {
        var r = new RoleEntity();
        r.setName(roleName);
        roles.save(r);
        return r;
    }
}
