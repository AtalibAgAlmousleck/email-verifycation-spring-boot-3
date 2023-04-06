package com.almousleck.user_api;
public record RegistrationRequest(
        String firstName, String lastName,
        String email, String password, String role
) {
}
