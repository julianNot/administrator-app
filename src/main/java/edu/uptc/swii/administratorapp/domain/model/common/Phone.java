package edu.uptc.swii.administratorapp.domain.model.common;

public record Phone(String value) {
    public Phone {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Phone cannot be empty");
        }
        if (!value.matches("^[0-9+-]+$")) {
            throw new IllegalArgumentException("Invalid phone format");
        }
    }
}
