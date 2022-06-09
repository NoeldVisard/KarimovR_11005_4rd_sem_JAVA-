package ru.itis.parking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.parking.dto.ParkingCarDto;
import ru.itis.parking.mapper.ParkingCarMapper;
import ru.itis.parking.models.Car;
import ru.itis.parking.models.Driver;
import ru.itis.parking.models.Parking;
import ru.itis.parking.models.ParkingCar;
import ru.itis.parking.repositories.CarRepository;
import ru.itis.parking.repositories.DriverRepository;
import ru.itis.parking.repositories.ParkingCarRepository;
import ru.itis.parking.repositories.ParkingRepository;
import ru.itis.parking.services.ParkingCarService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



@RequiredArgsConstructor
@Service
public class ParkingCarServiceImpl implements ParkingCarService {

    private final CarRepository carRepository;
    private final ParkingServiceImpl parkingService;
    private final ParkingCarRepository parkingCarRepository;
    private final DriverRepository driverRepository;
    private final ParkingCarMapper parkingCarMapper;

    @Override
    public ParkingCarDto addingCarInTheParking(Long carId, Long parkingId) {
        Car car = carRepository.getById(carId);
        Parking parking = parkingService.updateSlotsCountMinus(parkingId);


        return parkingCarMapper.getParkingCarDto(parkingCarRepository.save(ParkingCar.builder()
                .car(car)
                .parking(parking)
                .startTime(LocalTime.now())
                .build()));
    }

    @Override
    public ParkingCarDto deleteCarInTheParking(Long parkingCarId) {
        ParkingCar parkingCar = parkingCarRepository.getById(parkingCarId);
        Parking parking = parkingService.updateSlotsCountPlus(parkingCar.getParking().getId());
        Driver driver = parkingCar.getCar().getDriver();

        parkingCar.setEndTime(LocalTime.now());

        long diffMinute = parkingCar.getEndTime().getMinute() - parkingCar.getStartTime().getMinute();
        long diffHour = parkingCar.getEndTime().getHour() - parkingCar.getStartTime().getHour();

        if(diffHour == 0){
            diffHour = 1;
        } else {
            if(diffMinute > 30){
                diffHour += 1;
            }
        }
        Long finalPrice = diffHour * parking.getPriceForHour();
        parkingCar.setFinalPrice(finalPrice);
        driver.setMoney(driver.getMoney() - finalPrice);

        driverRepository.save(driver);

        return parkingCarMapper.getParkingCarDto(parkingCarRepository.save(parkingCar));
    }
}
