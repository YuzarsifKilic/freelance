package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record CreateAppealRequest(
        @NotEmpty
        Long advertisementId,
        @NotEmpty
        Long employeeId,
        @NotEmpty
        String commitment
) {
}
