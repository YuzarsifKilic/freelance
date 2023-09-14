package com.yuzarsif.freelance.request;

public record CreateDealRequest(
        Long employeeId,
        Long advertisementId
) {
}
