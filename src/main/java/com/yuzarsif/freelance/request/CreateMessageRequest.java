package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record CreateMessageRequest(
        @NotEmpty
        Long senderId,
        @NotEmpty
        Long receiverId,
        @NotEmpty
        String message
) {
}
