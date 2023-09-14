package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.MessageDto;
import com.yuzarsif.freelance.request.CreateMessageRequest;
import com.yuzarsif.freelance.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService service;

    public MessageController(MessageService service) {
        this.service = service;
    }

    @PostMapping
    public void sendMessage(@RequestBody CreateMessageRequest request) {
        service.sendMessage(request);
    }

    public ResponseEntity<List<MessageDto>> findMessages(@RequestParam("senderId") Long senderId, @RequestParam("receiverId") Long receiverId) {
        return ResponseEntity.ok(service.findMessages(senderId, receiverId));
    }
}
