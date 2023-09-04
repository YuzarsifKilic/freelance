package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Tag;

public record TagDto(
        Long id,
        String label
) {

    public static TagDto convert(Tag from) {
        return new TagDto(
                from.getId(),
                from.getLabelName());
    }
}
