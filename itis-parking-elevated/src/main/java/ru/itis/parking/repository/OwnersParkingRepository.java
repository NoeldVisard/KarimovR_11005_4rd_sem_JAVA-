package ru.itis.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.parking.entity.OwnerParking;

public interface OwnersParkingRepository extends JpaRepository<OwnerParking, Long> {
    @Query("SELECT * FROM OwnerParking WHERE OwnerParking.owner.id = id")
    OwnerParking getByOwnerId(@Param("id") Long id);
}
