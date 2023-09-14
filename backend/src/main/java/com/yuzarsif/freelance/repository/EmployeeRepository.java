package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
