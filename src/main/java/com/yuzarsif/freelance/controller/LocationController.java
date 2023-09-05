package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.LocationDto;
import com.yuzarsif.freelance.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/{location}")
    public ResponseEntity<List<LocationDto>> findLocationsByName(@PathVariable String location) {
        return ResponseEntity.ok(service.findLocationByCountryOrCity(location));
    }
}
