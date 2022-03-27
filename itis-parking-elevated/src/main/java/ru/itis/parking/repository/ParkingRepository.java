package ru.itis.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.parking.entity.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {
}
