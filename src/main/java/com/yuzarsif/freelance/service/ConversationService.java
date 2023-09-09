package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.ConversationDto;
import com.yuzarsif.freelance.model.Conversation;
import com.yuzarsif.freelance.model.User;
import com.yuzarsif.freelance.repository.ConversationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConversationService {

    private final ConversationRepository repository;
    private final UserService userService;

    public ConversationService(ConversationRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    protected Conversation findConversationBySenderIdAndReceiverId(Long senderId, Long receiverId) {
        Conversation conversation = repository.findBySender_IdAndReceiver_Id(senderId, receiverId);

        if (conversation == null) {
            Conversation createdConversation = createConversation(senderId, receiverId);
            return createdConversation;
        }

        return conversation;
    }

    private Conversation createConversation(Long senderId, Long receiverId) {
        User sender = userService.findUserById(senderId);
        User receiver = userService.findUserById(receiverId);

        Conversation conversation = Conversation.builder()
                .sender(sender)
                .receiver(receiver)
                .build();

        Conversation createdConversation = repository.save(conversation);

        return createdConversation;
    }

    public List<ConversationDto> findConversationsByEmployerId(Long employerId) {
        List<Conversation> conversations = repository.findByReceiver_Id(employerId);

        return conversations.stream()
                .map(ConversationDto::convert)
                .collect(Collectors.toList());
    }

    public List<ConversationDto> findConversationsByEmployeeId(Long employeeId) {
        List<Conversation> conversations = repository.findBySender_Id(employeeId);

        return conversations.stream()
                .map(ConversationDto::convert)
                .collect(Collectors.toList());
    }
}
