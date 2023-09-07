package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.AppealDto;
import com.yuzarsif.freelance.request.CreateAppealRequest;
import com.yuzarsif.freelance.service.AppealService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/appeals")
public class AppealController {

    private final AppealService service;

    public AppealController(AppealService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppealDto> findAppealById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealById(id));
    }

    @PostMapping
    public ResponseEntity<AppealDto> createAppeal(@RequestBody CreateAppealRequest request) {
        return ResponseEntity.ok(service.createAppeal(request));
    }

    @PostMapping("/{id}")
    public void appealSeen(@PathVariable Long id) {
        service.appealSeen(id);
    }

    @GetMapping("/advertisement/{id}/created-date-desc")
    public ResponseEntity<List<AppealDto>> findAppealsByAdvertisementIdOrderByCreatedDateDesc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByAdvertisementIdOrderByCreatedDateDesc(id));
    }

    @GetMapping("/advertisement/{id}/created-date-asc")
    public ResponseEntity<List<AppealDto>> findAppealsByAdvertisementIdOrderByCreatedDateAsc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByAdvertisementIdOrderByCreatedDateAsc(id));
    }

    @GetMapping("/employee/{id}/created-date-desc")
    public ResponseEntity<List<AppealDto>> findAppealsByEmployeeIdOrderByCreatedDateDesc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByEmployeeIdOrderByCreatedDateDesc(id));
    }

    @GetMapping("/employee/{id}/created-date-asc")
    public ResponseEntity<List<AppealDto>> findAppealsByEmployeeIdOrderByCreatedDateAsc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByEmployeeIdOrderByCreatedDateAsc(id));
    }

    @GetMapping("/employer/{id}/created-date-desc")
    public ResponseEntity<List<AppealDto>> findAppealsByEmployerIdOrderByCreatedDateDesc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByEmployerIdOrderByCreatedDateDesc(id));
    }

    @GetMapping("/employer/{id}/created-date-asc")
    public ResponseEntity<List<AppealDto>> findAppealsByEmployerIdOrderByCreatedDateAsc(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAppealsByEmployerIdOrderByCreatedDateAsc(id));
    }
}
