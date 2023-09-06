package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppealRepository extends JpaRepository<Appeal, Long> {

    List<Appeal> findByAdvertisement_Id(Long id);
}
