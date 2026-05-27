package com.selcan.tracking_service.service;

import com.selcan.tracking_service.entity.LocationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrackingService {

    private final StringRedisTemplate redisTemplate;
    private final SimpMessagingTemplate messagingTemplate;

    public void processLocation(LocationMessage msg) {

        // 1. Redis save
        String key = "vehicle:" + msg.getVehicleId();
        redisTemplate.opsForValue().set(key, msg.toString());

        // 2. WebSocket broadcast
        messagingTemplate.convertAndSend(
                "/topic/vehicles/" + msg.getVehicleId(),
                msg
        );
    }
}
