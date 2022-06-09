package ru.itis.parking.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.parking.dto.ParkingDto;
import ru.itis.parking.services.ParkingService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/parking")
public class ParkingController {

    private final ParkingService parkingService;

    @GetMapping
    public ResponseEntity<List<ParkingDto>> freeParking(){
        return ResponseEntity.ok(parkingService.getFreeParking());
    }
}
