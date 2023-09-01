package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {
}
