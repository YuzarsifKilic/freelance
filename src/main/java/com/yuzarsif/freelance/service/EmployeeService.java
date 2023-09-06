package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.EmployeeDto;
import com.yuzarsif.freelance.exceptioin.EmployeeNotFoundException;
import com.yuzarsif.freelance.model.Employee;
import com.yuzarsif.freelance.model.Role;
import com.yuzarsif.freelance.repository.EmployeeRepository;
import com.yuzarsif.freelance.request.CreateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeDto createEmployee(CreateEmployeeRequest request) {
        Employee employee = Employee.builder()
                .email(request.email())
                .username(request.username())
                .password(request.password())
                .role(Role.EMPLOYEE)
                .isActive(false)
                .resume(request.resume())
                .build();

        Employee savedEmployee = repository.save(employee);

        return EmployeeDto.convert(savedEmployee);
    }

    protected Employee getEmployee(Long id) {
        Employee employee = repository.findById(id)
                .orElseThrow(
                        () -> new EmployeeNotFoundException("Employee not found by id : " + id));

        return employee;
    }
}
