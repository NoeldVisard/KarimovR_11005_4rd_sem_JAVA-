package ru.itis.parking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.parking.dto.ParkingCarDto;
import ru.itis.parking.services.ParkingCarService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/parkingCar")
public class ParkingCarController {

    private final ParkingCarService parkingCarService;

    @GetMapping("/car/{car-id}/parking/{parking-id}")
    public ResponseEntity<ParkingCarDto> addingCarInTheParking(@PathVariable("car-id") Long carId,
                                                               @PathVariable("parking-id") Long parkingId){
        return ResponseEntity.ok(parkingCarService.addingCarInTheParking(carId, parkingId));
    }
    @GetMapping("/exit/{parkingCar-id}")
    public ResponseEntity<ParkingCarDto> deleteCarInTheParking(@PathVariable("parkingCar-id") Long parkingCarId){
        return ResponseEntity.ok(parkingCarService.deleteCarInTheParking(parkingCarId));

    }
}
