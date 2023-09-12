package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.DealDto;
import com.yuzarsif.freelance.exceptioin.DealNotFoundException;
import com.yuzarsif.freelance.model.Advertisement;
import com.yuzarsif.freelance.model.Deal;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.repository.DealRepository;
import com.yuzarsif.freelance.request.CreateDealRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealService {

    private final DealRepository repository;
    private final EmployeeService employeeService;
    private final AdvertisementSearchService advertisementSearchService;

    public DealService(DealRepository repository,
                       EmployeeService employeeService,
                       AdvertisementSearchService advertisementSearchService) {
        this.repository = repository;
        this.employeeService = employeeService;
        this.advertisementSearchService = advertisementSearchService;
    }

    public DealDto findDealById(Long id) {
        Deal deal = repository.findById(id)
                .orElseThrow(
                        () -> new DealNotFoundException("Deal not found by id : " + id));

        return DealDto.convert(deal);
    }

    public DealDto createDeal(CreateDealRequest request) {
        Employee employee = employeeService.getEmployee(request.employeeId());
        Advertisement advertisement = advertisementSearchService.getAdvertisementById(request.advertisementId());

        Deal deal = Deal.builder()
                .employee(employee)
                .advertisement(advertisement)
                .build();

        Deal savedDeal = repository.save(deal);

        return DealDto.convert(savedDeal);
    }

    public List<DealDto> findDealsByEmployeeId(Long employeeId) {
        List<Deal> deals = repository.findByEmployee_Id(employeeId);

        return deals.stream()
                .map(DealDto::convert)
                .collect(Collectors.toList());
    }

    public List<DealDto> findDealsByEmployerId(Long employerId) {
        List<Deal> deals = repository.findByAdvertisement_Employer_Id(employerId);

        return deals.stream()
                .map(DealDto::convert)
                .collect(Collectors.toList());
    }

    public DealDto findDealByAdvertisementId(Long advertisementId) {
        Deal deal = repository.findByAdvertisement_Id(advertisementId);

        return DealDto.convert(deal);
    }
}
