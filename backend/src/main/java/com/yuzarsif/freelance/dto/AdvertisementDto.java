package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Advertisement;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

public record AdvertisementDto(
        Long id,
        String header,
        String description,
        Set<CategoryDto> categories,
        Set<TagDto> tags,
        EmployerDto employer,
        boolean isDone,
        int price,
        int duration,
        LocalDateTime createdDate,
        LocalDateTime updatedDate
) {

    public static AdvertisementDto convert(Advertisement from) {
        return new AdvertisementDto(
                from.getId(),
                from.getHeader(),
                from.getDescription(),
                from.getCategory().stream()
                        .map(CategoryDto::convert)
                        .collect(Collectors.toSet()),
                from.getTags().stream()
                        .map(TagDto::convert)
                        .collect(Collectors.toSet()),
                EmployerDto.convert(from.getEmployer()),
                from.isDone(),
                from.getPrice(),
                from.getDuration(),
                from.getCreatedDate(),
                from.getUpdatedDate());
    }
}
