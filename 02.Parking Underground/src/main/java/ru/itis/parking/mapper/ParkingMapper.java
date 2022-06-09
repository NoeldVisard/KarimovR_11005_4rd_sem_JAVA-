package ru.itis.parking.mapper;

import org.mapstruct.Mapper;
import ru.itis.parking.dto.ParkingDto;
import ru.itis.parking.models.Parking;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParkingMapper {
    ParkingDto getParkingDto(Parking parking);
    List<ParkingDto> getParkingDtoList(List<Parking> parking);


}
