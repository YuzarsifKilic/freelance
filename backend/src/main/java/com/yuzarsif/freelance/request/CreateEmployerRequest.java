package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record CreateEmployerRequest(
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        String password,
        @NotEmpty
        String username,
        @NotEmpty
        Long locationId
) {
}
