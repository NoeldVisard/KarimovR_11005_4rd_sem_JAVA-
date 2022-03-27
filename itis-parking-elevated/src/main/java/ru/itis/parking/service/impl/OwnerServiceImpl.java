package ru.itis.parking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.parking.entity.Owner;
import ru.itis.parking.repository.OwnerRepository;
import ru.itis.parking.service.OwnerService;

import java.util.List;

public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Owner addOwner(Owner owner) {
        return ownerRepository.saveAndFlush(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner getById(Long id) {
        return ownerRepository.getById(id);
    }

    @Override
    public Owner getByName(String name) {
        return ownerRepository.getByName(name);
    }

    @Override
    public List<Owner> getAll() {
        return ownerRepository.findAll();
    }
}
