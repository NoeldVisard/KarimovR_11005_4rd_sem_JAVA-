package ru.itis.parking.service;

import ru.itis.parking.entity.Parking;

import java.util.List;

public interface ParkingService {

    Parking addParking(Parking parking);
    void deleteParking(Long id);
    Parking getById(Long id);
    List<Parking> getAll();
}
