package com.yuzarsif.freelance.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record CreateEmployeeRequest(
        @NotEmpty
        @Email
        String email,
        @NotEmpty
        String password,
        @NotEmpty
        String username,
        @NotEmpty
        String resume
) {
}
