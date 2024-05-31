package it.schipani.businessLayer.services;


import it.schipani.businessLayer.services.dto.RegisterEmployeeDto;

public interface Mapper<S, D> {

    S map(RegisterEmployeeDto input);

}
