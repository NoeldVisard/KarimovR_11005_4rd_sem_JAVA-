package ru.itis.parking.services;

import ru.itis.parking.dto.CarDto;

public interface CarService {
    CarDto addCar(CarDto carDto, Long driverId);
}
