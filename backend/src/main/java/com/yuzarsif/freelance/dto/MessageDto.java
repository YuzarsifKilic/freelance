package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Message;

import java.time.LocalDateTime;

public record MessageDto(
        Long id,
        ConversationDto conversation,
        String message,
        boolean isSeen,
        LocalDateTime sentDate
) {

    public static MessageDto convert(Message from) {
        return new MessageDto(
                from.getId(),
                ConversationDto.convert(from.getConversation()),
                from.getMessage(),
                from.isSeen(),
                from.getSentDate());
    }
}
