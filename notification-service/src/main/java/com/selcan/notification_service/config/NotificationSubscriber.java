package com.selcan.notification_service.config;

import com.selcan.notification_service.model.NotificationMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
@Slf4j
public class NotificationSubscriber {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public void onMessage(String message, String pattern) {

        try {
            NotificationMessage notif =
                    objectMapper.readValue(message, NotificationMessage.class);

            log.info("📩 NOTIFICATION RECEIVED: {}", notif);

            // burada later:
            // - email send
            // - websocket push
            // - db save

        } catch (Exception e) {
            log.error("Error parsing notification", e);
        }
    }
}
