package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.AppealDto;
import com.yuzarsif.freelance.exceptioin.AppealNotFoundException;
import com.yuzarsif.freelance.model.Advertisement;
import com.yuzarsif.freelance.model.Appeal;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.repository.AppealRepository;
import com.yuzarsif.freelance.request.CreateAppealRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppealService {

    private final AppealRepository repository;
    private final AdvertisementSearchService advertisementSearchService;
    private final EmployeeService employeeService;

    public AppealService(AppealRepository repository,
                         AdvertisementSearchService advertisementSearchService,
                         EmployeeService employeeService) {
        this.repository = repository;
        this.advertisementSearchService = advertisementSearchService;
        this.employeeService = employeeService;
    }

    public List<AppealDto> findAppealsByAdvertisementId(Long id) {
        List<Appeal> appeals = repository.findByAdvertisement_Id(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }

    public void appealSeen(Long id) {
        Appeal appeal = repository.findById(id)
                .orElseThrow(
                        () -> new AppealNotFoundException("Appeal not found by id : " + id));

        appeal.setSeen(true);

        repository.save(appeal);
    }

    public AppealDto createAppeal(CreateAppealRequest request) {
        Advertisement advertisement = advertisementSearchService.getAdvertisementById(request.advertisementId());
        Employee employee = employeeService.getEmployee(request.employeeId());

        Appeal appeal = Appeal.builder()
                .advertisement(advertisement)
                .employee(employee)
                .commitment(request.commitment())
                .build();

        Appeal savedAppeal = repository.save(appeal);

        return AppealDto.convert(savedAppeal);
    }
}
