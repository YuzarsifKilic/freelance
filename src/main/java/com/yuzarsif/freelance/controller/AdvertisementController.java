package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.request.CreateAdvertisementRequest;
import com.yuzarsif.freelance.service.AdvertisementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/advertisements")
public class AdvertisementController {

    private final AdvertisementService service;

    public AdvertisementController(AdvertisementService service) {
        this.service = service;
    }

    @PostMapping
    public String createAdvertisement(@RequestBody CreateAdvertisementRequest request) {
        service.createAdvertisement(request);
        return "Created Advertisement";
    }
}
