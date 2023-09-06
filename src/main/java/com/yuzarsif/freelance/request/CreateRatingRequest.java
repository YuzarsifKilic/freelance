package com.yuzarsif.freelance.request;

public record CreateRatingRequest(
        Long employerId,
        Long employeeId,
        float evaluation,
        String comment
) {
}
