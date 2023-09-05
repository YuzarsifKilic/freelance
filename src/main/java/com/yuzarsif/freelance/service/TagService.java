package com.yuzarsif.freelance.service;

import com.yuzarsif.freelance.dto.TagDto;
import com.yuzarsif.freelance.exceptioin.TagNotFoundException;
import com.yuzarsif.freelance.model.Tag;
import com.yuzarsif.freelance.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository repository;

    public TagService(TagRepository repository) {
        this.repository = repository;
    }

    public List<TagDto> findTagsByLabelName(String labelName) {
        List<Tag> tags = repository.findByLabelNameContains(labelName);

        return tags.stream()
                .map(TagDto::convert)
                .collect(Collectors.toList());
    }

    protected Tag findTagById(Long id) {
        Tag tag = repository.findById(id)
                .orElseThrow(
                        () -> new TagNotFoundException("Tag didnt find by id : " + id));

        return tag;
    }
}
