package ru.itis.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.parking.entity.Parking;
import ru.itis.parking.repository.ParkingRepository;
import ru.itis.parking.service.ParkingService;

import java.util.List;

public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;

    @Override
    public Parking addParking(Parking parking) {
        return parkingRepository.saveAndFlush(parking);
    }

    @Override
    public void deleteParking(Long id) {
        parkingRepository.deleteById(id);
    }

    @Override
    public Parking getById(Long id) {
        return parkingRepository.getById(id);
    }

    @Override
    public List<Parking> getAll() {
        return parkingRepository.findAll();
    }
}
