package com.selcan.tracking_service.controller;


import com.selcan.tracking_service.entity.LocationMessage;
import com.selcan.tracking_service.service.TrackingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    @PostMapping("/location")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void updateLocation(@RequestBody LocationMessage message) {
        trackingService.processLocation(message);
    }
}
