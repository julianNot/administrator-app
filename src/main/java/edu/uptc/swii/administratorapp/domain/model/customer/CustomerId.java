package edu.uptc.swii.administratorapp.domain.model.customer;

public record CustomerId(String value) {
    public CustomerId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be empty");
        }
    }
}