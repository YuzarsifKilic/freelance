package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.ConversationDto;
import com.yuzarsif.freelance.service.ConversationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/conversations")
public class ConversationController {

    private final ConversationService service;

    public ConversationController(ConversationService service) {
        this.service = service;
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<List<ConversationDto>> findConversationsByEmployerId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findConversationsByEmployerId(id));
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<ConversationDto>> findConversationsByEmployeeId(@PathVariable Long id) {
        return ResponseEntity.ok(service.findConversationsByEmployeeId(id));
    }
}
