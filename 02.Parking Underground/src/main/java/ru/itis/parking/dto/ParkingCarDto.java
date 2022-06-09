package ru.itis.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.parking.models.Car;
import ru.itis.parking.models.Parking;
import ru.itis.parking.models.ParkingCar;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingCarDto {
    private ParkingDto parking;
    private CarDto car;

}
