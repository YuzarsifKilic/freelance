package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Notification;

import java.time.LocalDateTime;

public record NotificationDto(
        Long id,
        UserDto user,
        String message,
        boolean isSeen,
        LocalDateTime createdDate
) {

    public static NotificationDto convert(Notification from) {
        return new NotificationDto(
                from.getId(),
                UserDto.convert(from.getUser()),
                from.getMessage(),
                from.isSeen(),
                from.getCreatedDate());
    }
}
