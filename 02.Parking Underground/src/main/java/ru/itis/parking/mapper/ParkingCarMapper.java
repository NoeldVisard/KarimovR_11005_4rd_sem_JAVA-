package ru.itis.parking.mapper;

import org.mapstruct.Mapper;
import ru.itis.parking.dto.ParkingCarDto;
import ru.itis.parking.models.ParkingCar;

@Mapper(componentModel = "spring")
public interface ParkingCarMapper {
    ParkingCarDto getParkingCarDto(ParkingCar parkingCar);
    ParkingCar getParking(ParkingCarDto parkingCarDto);
}
