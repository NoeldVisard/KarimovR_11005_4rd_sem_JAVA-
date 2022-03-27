package ru.itis.parking.service;

import ru.itis.parking.entity.OwnerParking;

import java.util.List;

public interface OwnerParkingService {

    OwnerParking setOwnerParking(OwnerParking ownerParking);
    void deleteOwnerParking(Long id);
    OwnerParking getById(Long id);
    OwnerParking getByOwnerId(Long id);
    List<OwnerParking> getAll();
}
