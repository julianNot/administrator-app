package edu.uptc.swii.administratorapp.domain.model.customer;

public record CustomerDocument(String value) {
    public CustomerDocument {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Document cannot be empty");
        }
    }
}
