package it.schipani.controller;

import it.schipani.controller.exceptions.EmployeeNotFoundException;
import it.schipani.controller.models.EmployeeValidationRequest;
import it.schipani.entities.Employee;
import it.schipani.services.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Optional<Employee> employee = service.getEmployee(id);
        return employee.map(e ->
                new ResponseEntity<>(e, HttpStatus.OK)).orElseGet(() ->
                new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody @Validated EmployeeValidationRequest request) {
        Employee employee = Employee.builder()
                .withUsername(request.username())
                .withFirstName(request.firstName())
                .withLastName(request.lastName())
                .withEmail(request.email())
                .build();

        Optional<Employee> savedEmployee = service.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee.get(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody @Validated EmployeeValidationRequest request) {
        try {
            Employee employeeDetails = Employee.builder()
                    .withUsername(request.username())
                    .withFirstName(request.firstName())
                    .withLastName(request.lastName())
                    .withEmail(request.email())
                    .build();
            Employee updatedEmployee = service.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updatedEmployee);
        } catch (EmployeeNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
