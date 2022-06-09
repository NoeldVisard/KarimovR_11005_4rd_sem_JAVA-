package ru.itis.parking.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import ru.itis.parking.dto.DriverDto;
import ru.itis.parking.validation.http.ValidationErrorDto;
import ru.itis.parking.validation.http.ValidationExceptionResponse;
import ru.itis.parking.services.DriverService;

import javax.validation.Valid;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/drivers")
public class DriverController {

    private final DriverService driverService;



    @PostMapping("/signIn")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DriverDto> addDriver(@Valid @RequestBody DriverDto driverDto){
        return ResponseEntity.ok(driverService.addDriver(driverDto));
    }

}
