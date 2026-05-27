package com.selcan.vehicle_service.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VehicleResponseDto {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private String plateNumber;
    private String status;
    private Long driverId;
    private DriverResponseDto driver;
}
