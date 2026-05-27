package com.selcan.driver_service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DriverResponseDto {
    private Long id;
    private String fullName;
    private String licenseNumber;
    private String phone;
    private String address;
}
