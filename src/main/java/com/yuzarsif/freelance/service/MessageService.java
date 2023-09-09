package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.MessageDto;
import com.yuzarsif.freelance.model.Conversation;
import com.yuzarsif.freelance.model.Message;
import com.yuzarsif.freelance.model.User;
import com.yuzarsif.freelance.repository.MessageRepository;
import com.yuzarsif.freelance.request.CreateMessageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository repository;
    private final ConversationService conversationService;
    private final NotificationService notificationService;
    private final UserService userService;

    public MessageService(MessageRepository repository,
                          ConversationService conversationService,
                          NotificationService notificationService,
                          UserService userService) {
        this.repository = repository;
        this.conversationService = conversationService;
        this.notificationService = notificationService;
        this.userService = userService;
    }

    public void sendMessage(CreateMessageRequest request) {
        User sender = userService.findUserById(request.senderId());
        User receiver = userService.findUserById(request.receiverId());

        Conversation conversation = conversationService
                .findConversationBySenderIdAndReceiverId(request.senderId(), request.receiverId());

        Message message = Message.builder()
                .conversation(conversation)
                .message(request.message())
                .isSeen(false)
                .build();

        repository.save(message);

        notificationService.createNotification(receiver, "You have a new message from : " + sender.getUsername());
    }

    public List<MessageDto> findMessages(Long senderId, Long receiverId) {
        List<Conversation> conversations = new ArrayList<>();
        conversations.add(conversationService.findConversationBySenderIdAndReceiverId(senderId, receiverId));
        conversations.add(conversationService.findConversationBySenderIdAndReceiverId(receiverId, senderId));

        List<Message> messages = repository.findByConversationIn(conversations);

        return messages.stream()
                .map(MessageDto::convert)
                .collect(Collectors.toList());
    }
}
