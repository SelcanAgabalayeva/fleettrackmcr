package com.selcan.vehicle_service.service;

import com.selcan.vehicle_service.dtos.VehicleRequestDto;
import com.selcan.vehicle_service.dtos.VehicleResponseDto;

import java.util.List;

public interface VehicleService {

    VehicleResponseDto create(VehicleRequestDto dto);

    VehicleResponseDto getById(Long id);

    List<VehicleResponseDto> getAll();

    VehicleResponseDto update(Long id, VehicleRequestDto dto);

    void delete(Long id);
}
