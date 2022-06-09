package ru.itis.parking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.parking.dto.CarDto;
import ru.itis.parking.mapper.CarMapper;
import ru.itis.parking.models.Car;
import ru.itis.parking.models.Driver;
import ru.itis.parking.repositories.CarRepository;
import ru.itis.parking.repositories.DriverRepository;
import ru.itis.parking.services.CarService;


@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final DriverRepository driverRepository;
    private final CarMapper carMapper;

    @Override
    public CarDto addCar(CarDto carDto, Long driverId) {
        Driver driver = driverRepository.getById(driverId);

        return carMapper.getCarDto(carRepository.save(Car.builder()
                        .model(carDto.getModel())
                        .color(carDto.getColor())
                        .carNumber(carDto.getCarNumber())
                        .driver(driver)
                .build()));
    }
}
