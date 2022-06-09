package ru.itis.parking.services;

import ru.itis.parking.dto.ParkingDto;
import ru.itis.parking.models.Parking;

import java.util.List;

public interface ParkingService {

    List<ParkingDto> getFreeParking();
    Parking updateSlotsCountMinus(Long parkingId);
    Parking updateSlotsCountPlus(Long parkingId);
}
