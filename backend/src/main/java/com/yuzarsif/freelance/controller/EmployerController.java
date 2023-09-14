package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.EmployerDto;
import com.yuzarsif.freelance.request.CreateEmployerRequest;
import com.yuzarsif.freelance.service.EmployerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController {

    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployerDto> createEmployer(@RequestBody CreateEmployerRequest request) {
        return ResponseEntity.ok(service.createEmployer(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployerDto> findEmployerById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findEmployerById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteEmployerById(@PathVariable Long id) {
        service.deleteEmployerById(id);
    }
}
