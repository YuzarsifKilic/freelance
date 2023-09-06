package com.yuzarsif.freelance.request;

public record CreateAppealRequest(
        Long advertisementId,
        Long employeeId,
        String commitment
) {
}
