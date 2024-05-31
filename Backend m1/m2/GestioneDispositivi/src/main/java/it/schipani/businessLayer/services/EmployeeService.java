package it.schipani.businessLayer.services;

import it.schipani.businessLayer.services.dto.RegisterEmployeeDto;
import it.schipani.businessLayer.services.dto.RegisteredEmployeeDto;
import it.schipani.dataLayer.entitys.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Optional<RegisteredEmployeeDto> register(RegisterEmployeeDto user);

    Optional<RegisteredEmployeeDto> login(String username, String password);

    ////////////////////////////////////////////////////////

    /*Optional<Employee> createEmployee(Employee e);*/

    List<Employee> getAllEmployee();

    Optional<Employee> getEmployee(Long id);

    Employee updateEmployee(Long id, Employee e);

    Employee delete(Long id);
}
