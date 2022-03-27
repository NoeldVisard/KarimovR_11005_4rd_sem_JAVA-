package ru.itis.parking.service;

import ru.itis.parking.entity.Owner;

import java.util.List;

public interface OwnerService {

    Owner addOwner(Owner owner);
    void deleteOwner(Long id);
    Owner getById(Long id);
    Owner getByName(String name);
    List<Owner> getAll();
}
