package com.yuzarsif.freelance.controller;

import com.yuzarsif.freelance.dto.TagDto;
import com.yuzarsif.freelance.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tags")
public class TagController {

    private final TagService service;

    public TagController(TagService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<TagDto>> findTagsByLabelName(@PathVariable String name) {
        return ResponseEntity.ok(service.findTagsByLabelName(name));
    }
}
