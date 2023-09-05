package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.model.Advertisement;
import com.yuzarsif.freelance.model.Category;
import com.yuzarsif.freelance.model.Employer;
import com.yuzarsif.freelance.model.Tag;
import com.yuzarsif.freelance.repository.AdvertisementRepository;
import com.yuzarsif.freelance.request.CreateAdvertisementRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdvertisementService {

    private final AdvertisementRepository repository;
    private final EmployerService employerService;
    private final CategoryService categoryService;
    private final TagService tagService;

    public AdvertisementService(AdvertisementRepository repository,
                                EmployerService employerService,
                                CategoryService categoryService,
                                TagService tagService) {
        this.repository = repository;
        this.employerService = employerService;
        this.categoryService = categoryService;
        this.tagService = tagService;
    }

    public void createAdvertisement(CreateAdvertisementRequest request) {
        Employer employer = employerService.findEmployerById(request.employerId());

        Set<Category> categories = new HashSet<>();

        for (int id : request.categoryId()) {
            Category category = categoryService.findCategoryById(id);
            categories.add(category);
        }

        Set<Tag> tags = new HashSet<>();

        for (Long id : request.tagId()) {
            Tag tag = tagService.findTagById(id);
            tags.add(tag);
        }

        Advertisement advertisement = Advertisement.builder()
                .header(request.header())
                .description(request.description())
                .category(categories)
                .tags(tags)
                .employer(employer)
                .isDone(false)
                .price(request.price())
                .duration(request.duration())
                .build();

        repository.save(advertisement);
    }
}