package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.NotificationDto;
import com.yuzarsif.freelance.service.NotificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {

    private final NotificationService service;

    public NotificationController(NotificationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationDto> findNotificationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findNotificationById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<NotificationDto>> findNotificationsByUserId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findNotificationByUserId(id));
    }

    @PostMapping("/{id}")
    public void seenNotification(@PathVariable Long id) {
        service.seenNotification(id);
    }
}
