package it.schipani.presentationLayer;

import it.schipani.businessLayer.services.EmployeeService;
import it.schipani.businessLayer.services.dto.RegisterEmployeeDto;
import it.schipani.presentationLayer.models.LoginModel;
import it.schipani.presentationLayer.models.RegisterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employees;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterModel model, //
                                      BindingResult validation) {
        if (validation.hasErrors()) {
            throw new RuntimeException();
        }
        var e = employees.register(RegisterEmployeeDto.builder() ////
                .withFullName(model.fullName())
                .withEmail(model.email())
                .withPassword(model.password())
                .build());
        return new ResponseEntity<>(e, HttpStatus.ACCEPTED);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {
        if (validation.hasErrors()) {
            throw new RuntimeException();
        }
        return new ResponseEntity<>(employees.login(model.fullName(), model.password()), //
                HttpStatus.OK);
    }
}
