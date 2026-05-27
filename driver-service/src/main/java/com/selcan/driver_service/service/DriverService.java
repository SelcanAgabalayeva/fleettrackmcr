package com.selcan.driver_service.service;

import com.selcan.driver_service.dtos.DriverRequestDto;
import com.selcan.driver_service.dtos.DriverResponseDto;

import java.util.List;

public interface DriverService {

    DriverResponseDto create(DriverRequestDto dto);

    DriverResponseDto getById(Long id);

    List<DriverResponseDto> getAll();

    DriverResponseDto update(Long id, DriverRequestDto dto);

    void delete(Long id);
}

