package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.RoleService;
import it.schipani.dataLayer.entities.RoleEntity;
import it.schipani.dataLayer.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roles;

    public RoleEntity save(String name){
        var r = new RoleEntity();
        r.setName(name);
        roles.save(r);
        return r;
    }

}
