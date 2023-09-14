package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Long> {


    List<Appeal> findByAdvertisement_IdOrderByCreatedDateDesc(Long id);

    List<Appeal> findByAdvertisement_IdOrderByCreatedDateAsc(Long id);

    List<Appeal> findByEmployee_IdOrderByCreatedDateDesc(Long id);

    List<Appeal> findByEmployee_IdOrderByCreatedDateAsc(Long id);

    List<Appeal> findByAdvertisement_Employer_IdOrderByCreatedDateDesc(Long id);

    List<Appeal> findByAdvertisement_Employer_IdOrderByCreatedDateAsc(Long id);
}
