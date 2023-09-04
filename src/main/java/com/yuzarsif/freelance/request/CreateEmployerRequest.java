package com.yuzarsif.freelance.request;

public record CreateEmployerRequest(
        String email,
        String password,
        String username,
        Long locationId
) {
}
