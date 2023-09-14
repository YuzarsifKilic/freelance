package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findByLabelNameContains(String labelName);

    List<Tag> findByCategory_Id(Long id);
}
