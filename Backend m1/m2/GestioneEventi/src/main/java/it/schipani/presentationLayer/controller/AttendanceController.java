package it.schipani.presentationLayer.controller;

import it.schipani.businessLayer.dto.AttendanceDto;
import it.schipani.businessLayer.impl.AttendanceServiceImpl;
import it.schipani.businessLayer.services.AttendanceService;
import it.schipani.dataLayer.entities.AttendanceEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceServiceImpl attendanceService;

    @PostMapping
    public ResponseEntity<AttendanceDto> createAttendance(@RequestBody @Validated AttendanceDto attendanceDto) {
        AttendanceEntity createdAttendanceEntity = attendanceService.createAttendance(attendanceDto);
        AttendanceDto createdAttendanceDto = attendanceService.mapToAttendanceDto(createdAttendanceEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAttendanceDto);
    }


}
