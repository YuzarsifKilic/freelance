package com.yuzarsif.freelance.request;

public record CreateAdvertisementRequest(
        String header,
        String description,
        int[] categoryId,
        Long[] tagId,
        Long employerId,
        int price,
        int duration

) {
}
