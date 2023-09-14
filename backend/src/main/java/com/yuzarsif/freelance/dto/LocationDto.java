package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Location;

public record LocationDto(
        Long id,
        String country,
        String city
) {

    public static LocationDto convert(Location from) {
        return new LocationDto(
                from.getId(),
                from.getCountry(),
                from.getCity());
    }
}
