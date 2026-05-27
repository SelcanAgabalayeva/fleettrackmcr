package com.selcan.vehicle_service.controller;

import com.selcan.vehicle_service.dtos.VehicleRequestDto;
import com.selcan.vehicle_service.dtos.VehicleResponseDto;
import com.selcan.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public VehicleResponseDto create(@RequestBody VehicleRequestDto dto) {
        return service.create(dto);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("/{id}")
    public VehicleResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public List<VehicleResponseDto> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public VehicleResponseDto update(@PathVariable Long id,
                                     @RequestBody VehicleRequestDto dto) {
        return service.update(id, dto);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
