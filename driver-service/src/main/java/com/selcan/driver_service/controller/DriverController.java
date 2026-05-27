package com.selcan.driver_service.controller;

import com.selcan.driver_service.dtos.DriverRequestDto;
import com.selcan.driver_service.dtos.DriverResponseDto;
import com.selcan.driver_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService service;
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public DriverResponseDto create(@RequestBody DriverRequestDto dto) {
        return service.create(dto);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/{id}")
    public DriverResponseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<DriverResponseDto> getAll() {
        return service.getAll();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public DriverResponseDto update(@PathVariable Long id,
                                    @RequestBody DriverRequestDto dto) {
        return service.update(id, dto);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
