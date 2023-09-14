package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Categories;
import com.yuzarsif.freelance.model.MainCategory;

public record MainCategoryDto(
        int id,
        Categories category
) {

    public static MainCategoryDto convert(MainCategory from) {
        return new MainCategoryDto(
                from.getId(),
                from.getCategory());
    }
}
