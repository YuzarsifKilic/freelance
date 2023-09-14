package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.CategoryDto;
import com.yuzarsif.freelance.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/main-category/{id}")
    public ResponseEntity<List<CategoryDto>> findAllCategories(@PathVariable int id) {
        return ResponseEntity.ok(service.findCategoriesByMainCategoryId(id));
    }
}
