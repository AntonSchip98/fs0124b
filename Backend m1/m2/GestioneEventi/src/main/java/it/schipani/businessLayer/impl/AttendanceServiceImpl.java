package it.schipani.businessLayer.impl;

import it.schipani.businessLayer.dto.AttendanceDto;
import it.schipani.businessLayer.services.AttendanceService;
import it.schipani.dataLayer.entities.AttendanceEntity;
import it.schipani.dataLayer.repositories.AttendanceRepository;
import it.schipani.dataLayer.repositories.EventRepository;
import it.schipani.dataLayer.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendances;

    @Autowired
    private UserRepository users;

    @Autowired
    private EventRepository events;


    // Altri metodi per la gestione delle prenotazioni possono essere aggiunti qui...

    // Metodo per mappare AttendanceDto a AttendanceEntity
    private AttendanceEntity mapToAttendanceEntity(AttendanceDto attendanceDto) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setUser(users.findById(attendanceDto.getUserId()).orElseThrow(() -> new IllegalArgumentException("User not found")));
        attendanceEntity.setEvent(events.findById(attendanceDto.getEventId()).orElseThrow(() -> new IllegalArgumentException("Event not found")));
        attendanceEntity.setStatus(attendanceDto.getStatus());
        return attendanceEntity;
    }

    // Metodo per mappare AttendanceEntity a AttendanceDto
    public AttendanceDto mapToAttendanceDto(AttendanceEntity attendanceEntity) {
        return AttendanceDto.builder()
                .withUserId(attendanceEntity.getUser().getId())
                .withEventId(attendanceEntity.getEvent().getId())
                .withStatus(attendanceEntity.getStatus())
                .build();
    }


    @Override
    public AttendanceEntity createAttendance(AttendanceDto attendance) {
        // Mappare il DTO a un'entità AttendanceEntity
        AttendanceEntity attendanceEntity = mapToAttendanceEntity(attendance);

        // Salvare l'entità nel repository e restituirla
        return attendances.save(attendanceEntity);
    }
}
