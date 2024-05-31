package it.schipani.businessLayer.services.impl;

import it.schipani.businessLayer.services.EmployeeService;
import it.schipani.businessLayer.services.Mapper;
import it.schipani.businessLayer.services.dto.RegisterEmployeeDto;
import it.schipani.businessLayer.services.dto.RegisteredEmployeeDto;
import it.schipani.businessLayer.services.exceptions.EmployeeNotFoundException;
import it.schipani.businessLayer.services.exceptions.InvalidLoginException;
import it.schipani.businessLayer.services.exceptions.PersistEntityException;
import it.schipani.config.JwtUtils;
import it.schipani.dataLayer.entitys.Employee;
import it.schipani.dataLayer.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
/* è un'implementazione del servizio utente che gestisce la registrazione e il login degli utenti.
 Utilizza il framework Spring per la gestione delle dipendenze
 e il logging, e interagisce con un repository per la persistenza dei dati.*/
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employees;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    private AuthenticationManager auth;

    @Autowired
    private JwtUtils jwt;

    @Autowired
    Mapper<RegisterEmployeeDto, Employee> dto2Entity;

    @Autowired
    Mapper<Employee, RegisteredEmployeeDto> entity2Dto;



    @Override
    public Optional<RegisteredEmployeeDto> register(RegisterEmployeeDto employee) {
        try {
            var e = dto2Entity.map(employee);
            var p = encoder.encode(employee.getPassword());
            log.info("Password encrypted: {}", p);
            e.setPassword(p);

            var savedEmployee = employees.save(e);
            return Optional.of(entity2Dto.map(savedEmployee));
        } catch (Exception e) {
            log.error(String.format("Exception saving employee %s", employee), e);
            throw new PersistEntityException(employee);
        }
    }



    @Override
    public Optional<RegisteredEmployeeDto> login(String username, String password) {
        try {
            var e = employees.findOneByFullNameAndPassword(username, password).orElseThrow();
            return Optional.of(RegisteredEmployeeDto.builder()
                    .withFullName(e.getFullName())
                    .withId(e.getId())
                    .withEmail(e.getEmail())
                    .build());
        } catch (NoSuchElementException e) {
            log.error("Employee not found", e);
            throw new InvalidLoginException(username, password);
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////

 /*   @Override
    public Optional<Employee> createEmployee(Employee e) {
        return Optional.of(employees.save(e));
    }*/

    @Override
    public List<Employee> getAllEmployee() {
        return employees.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long id) {
        return employees.findById(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee e) {
        Optional<Employee> existingEmployeeOptional = employees.findById(id);
        if (existingEmployeeOptional.isPresent()) {
            Employee employeeToUpdate = existingEmployeeOptional.get();

            return employees.save(Employee.builder()
                    .withFullName(e.getFullName())
                    .withEmail(e.getEmail())
                    .withPassword(e.getPassword())
                    .withDevices(e.getDevices())
                    .build());

        } else {
            throw new EmployeeNotFoundException(List.of(new ObjectError("employee", "Employee not found with id " + id)));
        }
    }

    @Override
    public Employee delete(Long id) {
        Optional<Employee> employeeOptional = employees.findById(id);
        if (employeeOptional.isPresent()) {
            employees.deleteById(id);
            return employeeOptional.get();
        } else {
            throw new EmployeeNotFoundException(List.of(new ObjectError("employee", "Employee not found with id " + id)));
        }
    }
}
