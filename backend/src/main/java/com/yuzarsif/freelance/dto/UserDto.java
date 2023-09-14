package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Role;
import com.yuzarsif.freelance.model.User;

import java.time.LocalDateTime;

public record UserDto(
        Long id,
        String username,
        String email,
        Role role,
        boolean isActive,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {

    public static UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getEmail(),
                from.getRole(),
                from.isActive(),
                from.getCreatedDate(),
                from.getUpdatedDate());
    }
}
