package ru.itis.parking.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.parking.dto.DriverDto;
import ru.itis.parking.mapper.DriverMapper;
import ru.itis.parking.models.Driver;
import ru.itis.parking.repositories.DriverRepository;
import ru.itis.parking.services.DriverService;



@RequiredArgsConstructor
@Service
public class DriverServiceImpl implements DriverService {

    final private DriverRepository driverRepository;
    final private DriverMapper driverMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public DriverDto addDriver(DriverDto driverDto) {
        return driverMapper.getDriverDto(driverRepository.save(
                Driver.builder()
                .firstName(driverDto.getFirstName())
                .lastName(driverDto.getLastName())
                .login(driverDto.getLogin())
                .password(passwordEncoder.encode(driverDto.getPassword()))
                        .role(driverDto.getRole())
                        .state(driverDto.getState())
                .build()));

    }
}
