package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
