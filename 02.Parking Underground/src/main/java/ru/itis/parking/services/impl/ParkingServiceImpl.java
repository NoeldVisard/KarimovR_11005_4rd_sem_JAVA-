package ru.itis.parking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.parking.dto.ParkingDto;
import ru.itis.parking.mapper.ParkingMapper;
import ru.itis.parking.models.Parking;
import ru.itis.parking.repositories.ParkingRepository;
import ru.itis.parking.services.ParkingService;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParkingServiceImpl implements ParkingService {

    final private ParkingRepository parkingRepository;
    final private ParkingMapper parkingMapper;

    @Override
    public List<ParkingDto> getFreeParking() {
        return parkingMapper.getParkingDtoList(parkingRepository.findAll());
    }

    @Override
    public Parking updateSlotsCountMinus(Long parkingId) {
        Parking parking = parkingRepository.getById(parkingId);

        parking.setSlotsCount(parking.getSlotsCount() - 1);

        return parkingRepository.save(parking);
    }

    @Override
    public Parking updateSlotsCountPlus(Long parkingId) {
        Parking parking = parkingRepository.getById(parkingId);

        parking.setSlotsCount(parking.getSlotsCount() + 1);

        return parkingRepository.save(parking);
    }
}
