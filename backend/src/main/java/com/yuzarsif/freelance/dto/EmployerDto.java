package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Employer;

import java.time.LocalDateTime;

public record EmployerDto(
        Long id,
        String email,
        String username,
        boolean isActive,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        LocationDto location
) {

    public static EmployerDto convert(Employer from) {
        return new EmployerDto(
                from.getId(),
                from.getEmail(),
                from.getUsername(),
                from.isActive(),
                from.getCreatedDate(),
                from.getUpdatedDate(),
                LocationDto.convert(from.getLocation()));
    }
}
