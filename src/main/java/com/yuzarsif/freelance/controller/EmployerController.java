package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.request.CreateEmployerRequest;
import com.yuzarsif.freelance.service.EmployerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController {

    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @PostMapping
    public String createEmployer(@RequestBody CreateEmployerRequest request) {
        service.createEmployer(request);
        return "Employer created";
    }
}
