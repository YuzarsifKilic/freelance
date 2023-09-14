package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByCountryContaining(String country);

    List<Location> findByCityContaining(String city);
}
