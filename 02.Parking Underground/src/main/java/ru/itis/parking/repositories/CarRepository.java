package ru.itis.parking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.parking.models.Car;


public interface CarRepository extends JpaRepository<Car,Long> {
}
