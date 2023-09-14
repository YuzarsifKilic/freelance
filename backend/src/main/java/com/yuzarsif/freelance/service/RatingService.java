package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.RatingDto;
import com.yuzarsif.freelance.exceptioin.RatingNotFoundException;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.model.Employer;
import com.yuzarsif.freelance.model.Rating;
import com.yuzarsif.freelance.repository.RatingRepository;
import com.yuzarsif.freelance.request.CreateRatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingService {

    private final RatingRepository repository;
    private final EmployeeService employeeService;
    private final EmployerService employerService;

    public RatingService(RatingRepository repository,
                         EmployeeService employeeService,
                         EmployerService employerService) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.employerService = employerService;
    }

    public List<RatingDto> findRatingByEmployeeIdOrderByCreatedDateDesc(Long id) {
        List<Rating> ratings = repository.findByEmployee_IdOrderByCreatedDateDesc(id);

        return ratings.stream()
                .map(RatingDto::convert)
                .collect(Collectors.toList());
    }

    public List<RatingDto> findRatingByEmployeeIdOrderByCreatedDateAsc(Long id) {
        List<Rating> ratings = repository.findByEmployee_IdOrderByCreatedDateAsc(id);

        return ratings.stream()
                .map(RatingDto::convert)
                .collect(Collectors.toList());
    }

    public RatingDto createRating(CreateRatingRequest request) {
        Employee employee = employeeService.getEmployee(request.employeeId());
        Employer employer = employerService.getEmployer(request.employerId());

        Rating rating = Rating.builder()
                .employee(employee)
                .employer(employer)
                .evaluation(request.evaluation())
                .comment(request.comment())
                .build();

        Rating savedRating = repository.save(rating);

        return RatingDto.convert(savedRating);
    }

    public void deleteRating(Long id) {
        Rating rating = getRating(id);

        repository.deleteById(rating.getId());
    }

    private Rating getRating(Long id) {
        Rating rating = repository.findById(id)
                .orElseThrow(
                        () -> new RatingNotFoundException("Rating not found by id : " + id));

        return rating;
    }
}
