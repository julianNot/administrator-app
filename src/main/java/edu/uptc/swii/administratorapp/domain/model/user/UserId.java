package edu.uptc.swii.administratorapp.domain.model.user;

public record UserId(String value) {
    public UserId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
    }
}