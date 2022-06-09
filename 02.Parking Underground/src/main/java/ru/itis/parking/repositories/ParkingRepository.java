package ru.itis.parking.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.parking.models.Parking;

public interface ParkingRepository extends JpaRepository<Parking, Long> {

}
