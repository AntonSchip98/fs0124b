package it.schipani.presentationLayer;

import it.schipani.businessLayer.RoleService;
import it.schipani.dataLayer.entities.RoleEntity;
import it.schipani.presentationLayer.models.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/roles")
public class RoleController {

    @Autowired
    private RoleService roles;


    @PostMapping
    public ResponseEntity<RoleEntity> createRole(@RequestBody RoleModel model) {

        RoleEntity savedRole = roles.save(model.name());
        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }
}
