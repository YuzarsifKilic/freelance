package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Rating;

public record RatingDto(
        Long id,
        EmployerDto employer,
        EmployeeDto employee,
        float evaluation,
        String comment
) {

    public static RatingDto convert(Rating from) {
        return new RatingDto(
                from.getId(),
                EmployerDto.convert(from.getEmployer()),
                EmployeeDto.convert(from.getEmployee()),
                from.getEvaluation(),
                from.getComment());
    }
}
