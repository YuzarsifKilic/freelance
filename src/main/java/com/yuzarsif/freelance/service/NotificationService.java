package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.NotificationDto;
import com.yuzarsif.freelance.exceptioin.NotificationNotFoundException;
import com.yuzarsif.freelance.model.Notification;
import com.yuzarsif.freelance.model.User;
import com.yuzarsif.freelance.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public NotificationDto findNotificationById(Long id) {
        Notification notification = getNotification(id);

        return NotificationDto.convert(notification);
    }

    private Notification getNotification(Long id) {
        return repository.findById(id)
                .orElseThrow(
                        () -> new NotificationNotFoundException("Notification didnt find by id : " + id));
    }

    public NotificationDto createNotification(User user, String message) {
        Notification notification = Notification.builder()
                .user(user)
                .message(message)
                .isSeen(false)
                .build();

        Notification savedNotification = repository.save(notification);

        return NotificationDto.convert(savedNotification);
    }

    public List<NotificationDto> findNotificationByUserId(Long id) {
        List<Notification> notifications = repository.findByUser_IdOrderByCreatedDateDesc(id);

        return notifications.stream()
                .map(NotificationDto::convert)
                .collect(Collectors.toList());
    }

    public void seenNotification(Long id) {
        Notification notification = getNotification(id);

        notification.setSeen(true);

        repository.save(notification);
    }
}
