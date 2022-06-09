package ru.itis.parking.services;

import ru.itis.parking.dto.ParkingCarDto;

public interface ParkingCarService {
    ParkingCarDto addingCarInTheParking(Long carId, Long parkingId);

    ParkingCarDto deleteCarInTheParking(Long parkingCarId);
}
