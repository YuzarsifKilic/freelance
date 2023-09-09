package com.yuzarsif.freelance.repository;

import com.yuzarsif.freelance.model.Conversation;
import com.yuzarsif.freelance.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByConversationIn(List<Conversation> conversations);
}
