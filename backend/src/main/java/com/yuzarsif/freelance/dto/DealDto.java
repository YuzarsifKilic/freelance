package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Deal;

import java.time.LocalDateTime;

public record DealDto(
        Long id,
        EmployeeDto employee,
        AdvertisementDto advertisement,
        LocalDateTime dealDate
) {

    public static DealDto convert(Deal from) {
        return new DealDto(
                from.getId(),
                EmployeeDto.convert(from.getEmployee()),
                AdvertisementDto.convert(from.getAdvertisement()),
                from.getDealDate());
    }
}
