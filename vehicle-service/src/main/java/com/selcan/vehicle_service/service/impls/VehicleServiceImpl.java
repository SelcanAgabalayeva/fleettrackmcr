package com.selcan.vehicle_service.service.impls;

import com.selcan.vehicle_service.client.DriverClient;
import com.selcan.vehicle_service.dtos.DriverResponseDto;
import com.selcan.vehicle_service.dtos.VehicleRequestDto;
import com.selcan.vehicle_service.dtos.VehicleResponseDto;
import com.selcan.vehicle_service.entity.Vehicle;
import com.selcan.vehicle_service.entity.VehicleStatus;
import com.selcan.vehicle_service.repositories.VehicleRepository;
import com.selcan.vehicle_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;
    private final DriverClient driverClient;

    @Override
    public VehicleResponseDto create(VehicleRequestDto dto) {
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
            DriverResponseDto driver = driverClient.getDriverById(dto.getDriverId());

            if (driver == null) {
                throw new RuntimeException("Driver not found");
            }

            Vehicle vehicle = new Vehicle();
            vehicle.setMake(dto.getMake());
            vehicle.setModel(dto.getModel());
            vehicle.setYear(dto.getYear());
            vehicle.setPlateNumber(dto.getPlateNumber());
            vehicle.setStatus(VehicleStatus.ACTIVE);

            vehicle.setDriverId(dto.getDriverId());

            Vehicle saved = repository.save(vehicle);

            return mapToDto(saved);
    }

    @Override
    public VehicleResponseDto getById(Long id) {

        Vehicle v = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        DriverResponseDto driver = null;

        if (v.getDriverId() != null) {
            driver = driverClient.getDriverById(v.getDriverId());
        }

        return VehicleResponseDto.builder()
                .id(v.getId())
                .make(v.getMake())
                .model(v.getModel())
                .year(v.getYear())
                .plateNumber(v.getPlateNumber())
                .status(v.getStatus().name())
                .driver(driver)
                .build();
    }

    @Override
    public List<VehicleResponseDto> getAll() {
        return repository.findAll().stream().map(v -> {

            DriverResponseDto driver = null;

            if (v.getDriverId() != null) {
                driver = driverClient.getDriverById(v.getDriverId());
            }

            return VehicleResponseDto.builder()
                    .id(v.getId())
                    .make(v.getMake())
                    .model(v.getModel())
                    .year(v.getYear())
                    .plateNumber(v.getPlateNumber())
                    .status(v.getStatus().name())
                    .driver(driver)
                    .build();
        }).toList();
    }

    @Override
    public VehicleResponseDto update(Long id, VehicleRequestDto dto) {

        Vehicle vehicle = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vehicle not found"));

        vehicle.setMake(dto.getMake());
        vehicle.setModel(dto.getModel());
        vehicle.setYear(dto.getYear());
        vehicle.setPlateNumber(dto.getPlateNumber());
        vehicle.setDriverId(dto.getDriverId());

        return mapToDto(repository.save(vehicle));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private VehicleResponseDto mapToDto(Vehicle v) {

        DriverResponseDto driver =
                driverClient.getDriverById(v.getDriverId());

        return VehicleResponseDto.builder()
                .id(v.getId())
                .make(v.getMake())
                .model(v.getModel())
                .year(v.getYear())
                .plateNumber(v.getPlateNumber())
                .status(v.getStatus().name())
                .driverId(v.getDriverId())
                .driver(driver)
                .build();
    }
}
