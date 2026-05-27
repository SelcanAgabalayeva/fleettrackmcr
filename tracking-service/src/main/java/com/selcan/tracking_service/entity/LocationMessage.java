package com.selcan.tracking_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationMessage {
    private Long vehicleId;
    private Double latitude;
    private Double longitude;
    private Long timestamp;
}
