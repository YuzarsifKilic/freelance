package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Employee;

import java.time.LocalDateTime;

public record EmployeeDto(
        Long id,
        String email,
        String username,
        String resume,
        boolean isActive,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {

    public static EmployeeDto convert(Employee from) {
        return new EmployeeDto(
                from.getId(),
                from.getEmail(),
                from.getUsername(),
                from.getResume(),
                from.isActive(),
                from.getCreatedDate(),
                from.getUpdatedDate());
    }
}
