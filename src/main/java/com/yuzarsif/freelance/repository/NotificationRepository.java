package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findByUser_IdOrderByCreatedDateDesc(Long id);
}
