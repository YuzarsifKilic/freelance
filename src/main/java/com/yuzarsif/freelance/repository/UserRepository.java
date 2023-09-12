package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
