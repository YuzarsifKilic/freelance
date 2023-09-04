package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.exceptioin.EmployerNotFoundException;
import com.yuzarsif.freelance.model.Employer;
import com.yuzarsif.freelance.model.Location;
import com.yuzarsif.freelance.model.Role;
import com.yuzarsif.freelance.repository.EmployerRepository;
import com.yuzarsif.freelance.request.CreateEmployerRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    private final EmployerRepository repository;
    private final LocationService locationService;

    public EmployerService(EmployerRepository repository, LocationService locationService) {
        this.repository = repository;
        this.locationService = locationService;
    }

    public Employer findEmployerById(Long id) {
        Employer employer = repository.findById(id)
                .orElseThrow(
                        () -> new EmployerNotFoundException("Employer didnt find by id : " + id));

        return employer;
    }

    public void createEmployer(CreateEmployerRequest request) {
        Location location = locationService.findLocationById(request.locationId());

        Employer employer = Employer.builder()
                .email(request.email())
                .username(request.username())
                .password(request.password())
                .role(Role.EMPLOYER)
                .isActive(false)
                .location(location)
                .build();

        repository.save(employer);
    }
}
