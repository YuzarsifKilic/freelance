package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.CategoryDto;
import com.yuzarsif.freelance.exceptioin.CategoryNotFoundException;
import com.yuzarsif.freelance.model.Category;
import com.yuzarsif.freelance.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    protected Category findCategoryById(Long id) {
        Category category = repository.findById(id)
                .orElseThrow(
                        () -> new CategoryNotFoundException("Category didnt find by id : " + id));

        return category;
    }

    public List<CategoryDto> findCategoriesByMainCategoryId(int id) {
        List<Category> categories = repository.findByMainCategory_Id(id);

        return categories.stream()
                .map(CategoryDto::convert)
                .collect(Collectors.toList());
    }
}
