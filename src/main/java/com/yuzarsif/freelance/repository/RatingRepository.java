package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByEmployee_IdOrderByCreatedDateDesc(Long id);

    List<Rating> findByEmployee_IdOrderByCreatedDateAsc(Long id);
}
