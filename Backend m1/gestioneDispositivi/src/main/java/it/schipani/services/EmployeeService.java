package it.schipani.services;

import it.schipani.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Optional<Employee> createEmployee(Employee e);

    List<Employee> getAllEmployee();

    Optional<Employee> getEmployee(Long id);

    Employee updateEmployee(Long id, Employee e);

    Employee delete(Long id);
}
