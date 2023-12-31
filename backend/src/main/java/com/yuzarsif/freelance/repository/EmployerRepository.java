package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
