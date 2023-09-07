package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.RatingDto;
import com.yuzarsif.freelance.request.CreateRatingRequest;
import com.yuzarsif.freelance.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ratings")
public class RatingController {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RatingDto> createRating(@RequestBody CreateRatingRequest request) {
        return ResponseEntity.ok(service.createRating(request));
    }

    @GetMapping("/employee/{id}/created-date-desc")
    public ResponseEntity<List<RatingDto>> findRatingByEmployeeIdOrderByCreatedDateDesc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findRatingByEmployeeIdOrderByCreatedDateDesc(id));
    }

    @GetMapping("/employee/{id}/created-date-asc")
    public ResponseEntity<List<RatingDto>> findRatingByEmployeeIdOrderByCreatedDateAsc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findRatingByEmployeeIdOrderByCreatedDateAsc(id));
    }
}
