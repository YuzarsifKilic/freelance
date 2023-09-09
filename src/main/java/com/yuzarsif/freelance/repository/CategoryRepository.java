package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByMainCategory_Id(int id);
}
