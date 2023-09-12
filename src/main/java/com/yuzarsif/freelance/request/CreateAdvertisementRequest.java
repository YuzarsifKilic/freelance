package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateAdvertisementRequest(

        @NotEmpty
        String header,
        @NotEmpty
        String description,
        @NotEmpty@Size(min = 1)
        Long[] categoryId,
        @NotEmpty@Size(min = 1)
        Long[] tagId,
        @NotEmpty
        Long employerId,
        @NotEmpty@Positive
        int price,
        @NotEmpty@Positive
        int duration

) {
}
