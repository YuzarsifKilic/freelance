package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Category;

public record CategoryDto(
        Long id,
        MainCategoryDto mainCategory,
        String subCategoryName
) {

    public static CategoryDto convert(Category from) {
        return new CategoryDto(
                from.getId(),
                MainCategoryDto.convert(from.getMainCategory()),
                from.getSubCategoryName());
    }
}
