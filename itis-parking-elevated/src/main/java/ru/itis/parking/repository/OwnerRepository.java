package ru.itis.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.parking.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    @Query("SELECT * FROM Owner WHERE Owner.name = name")
    Owner getByName(@Param("name") String name);
}
