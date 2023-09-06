package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.AdvertisementDto;
import com.yuzarsif.freelance.request.CreateAdvertisementRequest;
import com.yuzarsif.freelance.service.AdvertisementSaveService;
import com.yuzarsif.freelance.service.AdvertisementSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/advertisements")
public class AdvertisementController {

    private final AdvertisementSaveService advertisementSaveService;
    private final AdvertisementSearchService advertisementSearchService;

    public AdvertisementController(AdvertisementSaveService advertisementSaveService,
                                   AdvertisementSearchService advertisementSearchService) {
        this.advertisementSaveService = advertisementSaveService;
        this.advertisementSearchService = advertisementSearchService;
    }

    @PostMapping
    public ResponseEntity<AdvertisementDto> createAdvertisement(@RequestBody CreateAdvertisementRequest request) {
        return ResponseEntity.ok(advertisementSaveService.createAdvertisement(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdvertisementDto> findAdvertisementById(@PathVariable Long id) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementByGivenId(id));
    }

    @DeleteMapping("/{id}")
    public void deleteAdvertisementById(@PathVariable Long id) {
        advertisementSaveService.deleteAdvertisement(id);
    }

    @PostMapping("/{id}")
    public void increaseAdvertisementViewsById(@PathVariable Long id) {
        advertisementSaveService.increaseAdvertisementViewsById(id);
    }

    @GetMapping("/{header}")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementsByHeader(@PathVariable String header) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementsByHeader(header));
    }

    @GetMapping("/order-created-date-desc")
    public ResponseEntity<List<AdvertisementDto>> orderAdvertisementByCreatedDatedDesc() {
        return ResponseEntity.ok(advertisementSearchService.orderAdvertisementByCreatedDateDesc());
    }

    @GetMapping("/order-created-date-asc")
    public ResponseEntity<List<AdvertisementDto>> orderAdvertisementByCreatedDatedAsc() {
        return ResponseEntity.ok(advertisementSearchService.orderAdvertisementByCreatedDateAsc());
    }

    @GetMapping("/{header}/order-created-date-desc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByCreatedDateDesc(@PathVariable String header) {
        return ResponseEntity.ok(
                advertisementSearchService.findAdvertisementByHeaderOrderByCreatedDateDesc(header));
    }

    @GetMapping("/{header}/order-created-date-asc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByCreatedDateAsc(@PathVariable String header) {
        return ResponseEntity.ok(
                advertisementSearchService.findAdvertisementByHeaderOrderByCreatedDateAsc(header));
    }

    @GetMapping("/{header}/order-views-desc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByViewsDesc(@PathVariable String header) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementByHeaderOrderByViewsDesc(header));
    }

    @GetMapping("/{header}/order-views-asc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByViewsAsc(@PathVariable String header) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementByHeaderOrderByViewsAsc(header));
    }

    @GetMapping("/{header}/order-price-desc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByPriceDesc(@PathVariable String header) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementByHeaderOrderByPriceDesc(header));
    }

    @GetMapping("/{header}/order-price-asc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementByHeaderOrderByPriceAsc(@PathVariable String header) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementByHeaderOrderByPriceAsc(header));
    }

    @GetMapping("/between-price")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementBetweenPrice(@RequestParam("startPrice") int startPrice, @RequestParam("endPrice") int endPrice) {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementBetweenPrice(startPrice, endPrice));
    }

    @GetMapping("/order-views-desc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementOrderByViewsDesc() {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementOrderByViewsDesc());
    }

    @GetMapping("/order-views-asc")
    public ResponseEntity<List<AdvertisementDto>> findAdvertisementOrderByViewsAsc() {
        return ResponseEntity.ok(advertisementSearchService.findAdvertisementOrderByViewsAsc());
    }
}
