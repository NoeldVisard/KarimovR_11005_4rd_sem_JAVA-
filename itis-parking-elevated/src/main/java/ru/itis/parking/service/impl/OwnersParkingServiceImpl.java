package ru.itis.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.parking.entity.OwnerParking;
import ru.itis.parking.repository.OwnersParkingRepository;
import ru.itis.parking.service.OwnerParkingService;

import java.util.List;

public class OwnersParkingServiceImpl implements OwnerParkingService {
    @Autowired
    OwnersParkingRepository ownersParkingRepository;

    @Override
    public OwnerParking setOwnerParking(OwnerParking ownerParking) {
        return ownersParkingRepository.saveAndFlush(ownerParking);
    }

    @Override
    public void deleteOwnerParking(Long id) {
        ownersParkingRepository.deleteById(id);
    }

    @Override
    public OwnerParking getById(Long id) {
        return ownersParkingRepository.getById(id);
    }

    @Override
    public OwnerParking getByOwnerId(Long id) {
        return ownersParkingRepository.getByOwnerId(id);
    }

    @Override
    public List<OwnerParking> getAll() {
        return ownersParkingRepository.findAll();
    }
}
