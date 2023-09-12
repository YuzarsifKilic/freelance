package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record CreateRatingRequest(
        @NotEmpty
        Long employerId,
        @NotEmpty
        Long employeeId,
        @NotEmpty@PositiveOrZero
        float evaluation,
        @NotEmpty
        String comment
) {
}
