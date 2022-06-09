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
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @Column(name = "price_for_hour")
    private Long priceForHour;

    @Column(name = "slots_count" )
    private Long slotsCount;

    @OneToMany(mappedBy = "parking")
    private List<ParkingCar> parkingCars;

}
