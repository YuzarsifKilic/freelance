package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.DealDto;
import com.yuzarsif.freelance.request.CreateDealRequest;
import com.yuzarsif.freelance.service.DealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/deals")
public class DealController {

    private final DealService service;

    public DealController(DealService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DealDto> createDeal(@RequestBody CreateDealRequest request) {
        return ResponseEntity.ok(service.createDeal(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DealDto> findDealById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDealById(id));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<DealDto>> findDealsByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDealsByEmployeeId(id));
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<List<DealDto>> findDealsByEmployerId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDealsByEmployerId(id));
    }

    @GetMapping("/advertisement/{id}")
    public ResponseEntity<DealDto> findDealsByAdvertisementId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findDealByAdvertisementId(id));
    }
}
