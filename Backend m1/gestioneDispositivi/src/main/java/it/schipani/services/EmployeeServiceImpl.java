package it.schipani.services;

import it.schipani.controller.exceptions.EmployeeNotFoundException;
import it.schipani.entities.Employee;
import it.schipani.repositories.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employees;

    @Override
    public Optional<Employee> createEmployee(Employee e) {
        return Optional.of(employees.save(e));
    }

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

            if (e.getUsername() != null) {
                employeeToUpdate.setUsername(e.getUsername());
            }
            if (e.getFirstName() != null) {
                employeeToUpdate.setFirstName(e.getFirstName());
            }
            if (e.getLastName() != null) {
                employeeToUpdate.setLastName(e.getLastName());
            }
            if (e.getEmail() != null) {
                employeeToUpdate.setEmail(e.getEmail());
            }
          /*  return employees.save(Employee.builder()
                    .withUsername(e.getUsername())
                    .withFirstName(e.getFirstName())
                    .withLastName(e.getLastName())
                    .withEmail(e.getEmail())
                    .withDevices(e.getDevices())
                    .build());*/

            return employees.save(employeeToUpdate);

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
