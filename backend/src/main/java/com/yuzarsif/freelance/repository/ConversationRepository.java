package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {

    Conversation findBySender_IdAndReceiver_Id(Long senderId, Long receiverId);

    List<Conversation> findBySender_Id(Long senderId);

    List<Conversation> findByReceiver_Id(Long receiverId);
}
