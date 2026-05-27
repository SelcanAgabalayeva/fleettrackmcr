package com.selcan.vehicle_service.client;

import com.selcan.vehicle_service.dtos.DriverResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "driver-service")
public interface DriverClient {

    @GetMapping("/drivers/{id}")
    DriverResponseDto getDriverById(@PathVariable Long id);
}
