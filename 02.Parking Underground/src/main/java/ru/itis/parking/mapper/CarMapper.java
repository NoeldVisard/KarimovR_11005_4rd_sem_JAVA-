package ru.itis.parking.mapper;
import org.mapstruct.Mapper;
import ru.itis.parking.dto.CarDto;
import ru.itis.parking.models.Car;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarDto getCarDto(Car car);
    Car getCar(CarDto carDto);
}
