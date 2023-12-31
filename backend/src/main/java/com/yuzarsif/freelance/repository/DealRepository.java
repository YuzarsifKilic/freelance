package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealRepository extends JpaRepository<Deal, Long> {

    Deal findByAdvertisement_Id(Long id);

    List<Deal> findByEmployee_Id(Long id);

    List<Deal> findByAdvertisement_Employer_Id(Long id);
}
