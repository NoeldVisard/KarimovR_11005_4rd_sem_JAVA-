package ru.itis.parking.mapper;

import org.mapstruct.Mapper;
import ru.itis.parking.dto.DriverDto;
import ru.itis.parking.models.Driver;

@Mapper(componentModel = "spring")
public interface DriverMapper {
    DriverDto getDriverDto(Driver driver);
    Driver getDriver(DriverDto driverDto);
}
