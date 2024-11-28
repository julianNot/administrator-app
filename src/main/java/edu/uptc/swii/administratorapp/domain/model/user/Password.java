package edu.uptc.swii.administratorapp.domain.model.user;

public record Password(String value) {
    public Password {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
        if (value.length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
    }
}