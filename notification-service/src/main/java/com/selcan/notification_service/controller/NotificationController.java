package com.selcan.notification_service.controller;

import com.selcan.notification_service.model.NotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notify")
public class NotificationController {

    private final StringRedisTemplate redisTemplate;

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PostMapping
    public String send(@RequestBody NotificationMessage message) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(message);

            redisTemplate.convertAndSend("notifications", json);

            return "sent";
        } catch (Exception e) {
            return "error";
        }
    }
}
