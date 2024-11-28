package edu.uptc.swii.administratorapp.domain.model.common;

public record Email(String value) {
    public Email {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if (!value.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }
}
