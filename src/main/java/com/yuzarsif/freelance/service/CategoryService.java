package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.exceptioin.CategoryNotFoundException;
import com.yuzarsif.freelance.model.Category;
import com.yuzarsif.freelance.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    protected Category findCategoryById(int id) {
        Category category = repository.findById(id)
                .orElseThrow(
                        () -> new CategoryNotFoundException("Category didnt find by id : " + id));

        return category;
    }
}
