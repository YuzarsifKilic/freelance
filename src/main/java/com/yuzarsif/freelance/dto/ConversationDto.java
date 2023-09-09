package com.yuzarsif.freelance.dto;

import com.yuzarsif.freelance.model.Conversation;

public record ConversationDto(
        Long id,
        UserDto sender,
        UserDto receiver
) {

    public static ConversationDto convert(Conversation from) {
        return new ConversationDto(
                from.getId(),
                UserDto.convert(from.getSender()),
                UserDto.convert(from.getReceiver()));
    }
}
