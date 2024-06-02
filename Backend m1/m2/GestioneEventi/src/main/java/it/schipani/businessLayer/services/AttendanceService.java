package it.schipani.businessLayer.services;

import it.schipani.businessLayer.dto.AttendanceDto;
import it.schipani.dataLayer.entities.AttendanceEntity;

public interface AttendanceService {
    AttendanceEntity createAttendance(AttendanceDto attendance);

}
