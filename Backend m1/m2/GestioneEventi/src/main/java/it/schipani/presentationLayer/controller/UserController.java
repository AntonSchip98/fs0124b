package it.schipani.presentationLayer.controller;


import it.schipani.businessLayer.dto.RegisterUserDto;
import it.schipani.businessLayer.dto.RegisteredUserDto;
import it.schipani.businessLayer.services.UserService;
import it.schipani.presentationLayer.exceptions.FieldValidationException;
import it.schipani.presentationLayer.models.LoginModel;
import it.schipani.presentationLayer.models.RegisterUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;


@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService users;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Validated RegisterUserModel model, //
                                      BindingResult validation, UriComponentsBuilder uri) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }
        var r = users.register(RegisterUserDto.builder() //
                .withPassword(model.password()) //
                .withUsername(model.username()).withRoles(model.roles()).build());
        var headers = new HttpHeaders();
        headers.add("Location", uri.path("/api/users/{id}").buildAndExpand(r.getId()).toString());
        return new ResponseEntity<>(r, headers, HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginModel model, //
                                   BindingResult validation) {
        if (validation.hasErrors()) {
            throw new FieldValidationException(validation.getAllErrors());
        }

        return new ResponseEntity<>(users.login(model.username(), model.password()).orElseThrow(), //
                HttpStatus.OK);
    }

    @GetMapping("{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<RegisteredUserDto> get(@PathVariable long id) {
        return users.get(id);
    }

}
