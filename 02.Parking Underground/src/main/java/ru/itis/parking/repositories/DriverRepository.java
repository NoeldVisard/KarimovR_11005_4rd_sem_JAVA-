package ru.itis.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.parking.models.Driver;

import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByLogin(String login);
}
