package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.EmployerDto;
import com.yuzarsif.freelance.exceptioin.EmailAlreadyExistsException;
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
    private final UserService userService;

    public EmployerService(EmployerRepository repository, LocationService locationService, UserService userService) {
        this.repository = repository;
        this.locationService = locationService;
        this.userService = userService;
    }

    public EmployerDto findEmployerById(Long id) {
        Employer employer = getEmployer(id);

        return EmployerDto.convert(employer);
    }

    protected Employer getEmployer(Long id) {
        Employer employer = repository.findById(id)
                .orElseThrow(
                        () -> new EmployerNotFoundException("Employer didnt find by id : " + id));
        return employer;
    }

    public EmployerDto createEmployer(CreateEmployerRequest request) {

        if (userService.emailInUse(request.email())) {
            throw new EmailAlreadyExistsException("Email : " + request.email() + " already in use!");
        }

        Location location = locationService.findLocationById(request.locationId());

        Employer employer = Employer.builder()
                .email(request.email())
                .username(request.username())
                .password(request.password())
                .role(Role.EMPLOYER)
                .isActive(false)
                .location(location)
                .build();

        Employer savedEmployer = repository.save(employer);

        return EmployerDto.convert(savedEmployer);
    }
    
    public void deleteEmployerById(Long id) {
        Employer employer = getEmployer(id);

        repository.deleteById(id);
    }
}
