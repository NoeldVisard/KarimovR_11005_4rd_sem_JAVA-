package ru.itis.parking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.parking.models.Parking;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingDto {
    private String address;
    private Long priceForHour;
    private Long slotsCount;

}
