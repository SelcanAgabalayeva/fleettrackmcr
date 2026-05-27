package com.selcan.driver_service.service.impls;

import com.selcan.driver_service.dtos.DriverRequestDto;
import com.selcan.driver_service.dtos.DriverResponseDto;
import com.selcan.driver_service.entity.Driver;
import com.selcan.driver_service.repositories.DriverRepository;
import com.selcan.driver_service.service.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final DriverRepository repository;

    @Override
    public DriverResponseDto create(DriverRequestDto dto) {

        Driver driver = new Driver();
        driver.setFullName(dto.getFullName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setPhone(dto.getPhone());
        driver.setAddress(dto.getAddress());

        Driver saved = repository.save(driver);

        return mapToDto(saved);
    }

    @Override
    public DriverResponseDto getById(Long id) {

        Driver driver = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        return mapToDto(driver);
    }

    @Override
    public List<DriverResponseDto> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public DriverResponseDto update(Long id, DriverRequestDto dto) {

        Driver driver = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Driver not found"));

        driver.setFullName(dto.getFullName());
        driver.setLicenseNumber(dto.getLicenseNumber());
        driver.setPhone(dto.getPhone());
        driver.setAddress(dto.getAddress());

        return mapToDto(repository.save(driver));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private DriverResponseDto mapToDto(Driver d) {
        return DriverResponseDto.builder()
                .id(d.getId())
                .fullName(d.getFullName())
                .licenseNumber(d.getLicenseNumber())
                .phone(d.getPhone())
                .address(d.getAddress())
                .build();
    }
}
