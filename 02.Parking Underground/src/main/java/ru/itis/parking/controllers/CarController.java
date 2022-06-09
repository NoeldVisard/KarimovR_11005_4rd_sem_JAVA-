package ru.itis.parking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.parking.dto.CarDto;
import ru.itis.parking.models.ParkingCar;
import ru.itis.parking.services.CarService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @PostMapping("/{driver-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto,
                                         @PathVariable("driver-id") Long driverId){
        return ResponseEntity.ok(carService.addCar(carDto, driverId));
    }


}
