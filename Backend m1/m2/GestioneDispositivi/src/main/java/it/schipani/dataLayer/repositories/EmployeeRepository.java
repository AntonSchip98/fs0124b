package it.schipani.dataLayer.repositories;

import it.schipani.dataLayer.entitys.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findOneByFullNameAndPassword(String fullName, String password);

    Optional<Employee> findOneByFullName(String fullName);
}
