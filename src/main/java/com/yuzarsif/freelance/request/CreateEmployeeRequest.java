package com.yuzarsif.freelance.request;

public record CreateEmployeeRequest(
        String email,
        String password,
        String username,
        String resume
) {
}
