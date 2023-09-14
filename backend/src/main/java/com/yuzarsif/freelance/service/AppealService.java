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
    private final NotificationService notificationService;

    public AppealService(AppealRepository repository,
                         AdvertisementSearchService advertisementSearchService,
                         EmployeeService employeeService,
                         NotificationService notificationService) {
        this.repository = repository;
        this.advertisementSearchService = advertisementSearchService;
        this.employeeService = employeeService;
        this.notificationService = notificationService;
    }

    public AppealDto findAppealById(Long id) {
        Appeal appeal = repository.findById(id)
                .orElseThrow(
                        () -> new AppealNotFoundException("Appeal didnt find by id : " + id));

        return AppealDto.convert(appeal);
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

        notificationService.createNotification(
                advertisement.getEmployer(),
                "There is a new appeal for your advertisement");

        return AppealDto.convert(savedAppeal);
    }

    public List<AppealDto> findAppealsByAdvertisementIdOrderByCreatedDateDesc(Long id) {
        List<Appeal> appeals = repository.findByAdvertisement_IdOrderByCreatedDateDesc(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }

    public List<AppealDto> findAppealsByAdvertisementIdOrderByCreatedDateAsc(Long id) {
        List<Appeal> appeals = repository.findByAdvertisement_IdOrderByCreatedDateAsc(id);

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

    public List<AppealDto> findAppealsByEmployeeIdOrderByCreatedDateDesc(Long id) {
        List<Appeal> appeals = repository.findByEmployee_IdOrderByCreatedDateDesc(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }

    public List<AppealDto> findAppealsByEmployeeIdOrderByCreatedDateAsc(Long id) {
        List<Appeal> appeals = repository.findByEmployee_IdOrderByCreatedDateAsc(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }

    public List<AppealDto> findAppealsByEmployerIdOrderByCreatedDateDesc(Long id) {
        List<Appeal> appeals = repository.findByAdvertisement_Employer_IdOrderByCreatedDateDesc(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }

    public List<AppealDto> findAppealsByEmployerIdOrderByCreatedDateAsc(Long id) {
        List<Appeal> appeals = repository.findByAdvertisement_Employer_IdOrderByCreatedDateAsc(id);

        return appeals.stream()
                .map(AppealDto::convert)
                .collect(Collectors.toList());
    }
}
