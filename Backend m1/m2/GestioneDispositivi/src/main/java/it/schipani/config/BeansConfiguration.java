package it.schipani.config;

import it.schipani.businessLayer.services.Mapper;
import it.schipani.businessLayer.services.dto.RegisterEmployeeDto;
import it.schipani.dataLayer.entitys.Employee;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class BeansConfiguration implements Mapper<RegisterEmployeeDto, Employee> {
    @Override
    public RegisterEmployeeDto convertTo(Employee input) {
        return RegisterEmployeeDto.builder()
                .withFullName(input.getFullName())
                .withPassword(input.getPassword())
                .build();
    }

    @Override
    public Employee convertFrom(RegisterEmployeeDto input) {
        return Employee.builder()
                .withFullName(input.getFullName())
                .withPassword(input.getPassword())
                .build();
    }

    @Override
    public RegisterEmployeeDto map(RegisterEmployeeDto input) {
        return null;
    }
}
