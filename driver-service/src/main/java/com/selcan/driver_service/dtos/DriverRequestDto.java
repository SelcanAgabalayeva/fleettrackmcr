package com.selcan.driver_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequestDto {
    private String fullName;
    private String licenseNumber;
    private String phone;
    private String address;
}
