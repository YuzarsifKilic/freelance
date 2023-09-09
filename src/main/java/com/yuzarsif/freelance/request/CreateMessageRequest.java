package com.yuzarsif.freelance.request;

public record CreateMessageRequest(
        Long senderId,
        Long receiverId,
        String message
) {
}
