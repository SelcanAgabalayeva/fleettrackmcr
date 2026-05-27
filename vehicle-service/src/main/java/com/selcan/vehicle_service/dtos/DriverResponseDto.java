package com.selcan.vehicle_service.dtos;

import lombok.Data;

@Data
public class DriverResponseDto {
    private Long id;
    private String fullName;
    private String licenseNumber;
    private String phone;
    private String address;
}
