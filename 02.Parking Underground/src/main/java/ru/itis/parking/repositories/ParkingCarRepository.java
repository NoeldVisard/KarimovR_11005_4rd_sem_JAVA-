package ru.itis.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.parking.models.ParkingCar;

public interface ParkingCarRepository extends JpaRepository<ParkingCar, Long> {
}
