package com.selcan.notification_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationMessage {

    private String type;
    private String message;
    private Long vehicleId;
    private Long timestamp;
}
