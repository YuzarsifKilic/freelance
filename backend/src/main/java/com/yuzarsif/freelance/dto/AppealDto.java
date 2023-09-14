package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Appeal;

public record AppealDto(
        Long id,
        AdvertisementDto advertisement,
        EmployeeDto employee,
        String commitment
) {

    public static AppealDto convert(Appeal from) {
        return new AppealDto(
                from.getId(),
                AdvertisementDto.convert(from.getAdvertisement()),
                EmployeeDto.convert(from.getEmployee()),
                from.getCommitment());
    }
}
