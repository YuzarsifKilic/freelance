package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.MainCategoryDto;
import com.yuzarsif.freelance.model.MainCategory;
import com.yuzarsif.freelance.repository.MainCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainCategoryService {

    private final MainCategoryRepository repository;

    public MainCategoryService(MainCategoryRepository repository) {
        this.repository = repository;
    }

    public List<MainCategoryDto> findAllMainCategories() {
        List<MainCategory> mainCategories = repository.findAll();

        return mainCategories.stream()
                .map(MainCategoryDto::convert)
                .collect(Collectors.toList());
    }
}
