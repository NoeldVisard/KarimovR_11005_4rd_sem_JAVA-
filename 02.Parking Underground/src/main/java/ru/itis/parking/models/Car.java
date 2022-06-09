package ru.itis.parking.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String color;

    @Column(name = "car_number")
    private String carNumber;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToMany(mappedBy = "car")
    private List<ParkingCar> parkingCars;
}
