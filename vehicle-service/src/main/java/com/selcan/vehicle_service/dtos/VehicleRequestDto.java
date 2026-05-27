package com.selcan.vehicle_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequestDto {
    private String make;
    private String model;
    private Integer year;
    private String plateNumber;
    private Long driverId;
}
