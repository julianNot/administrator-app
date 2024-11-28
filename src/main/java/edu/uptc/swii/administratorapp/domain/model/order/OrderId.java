package edu.uptc.swii.administratorapp.domain.model.order;

public record OrderId(String value) {
    public OrderId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be empty");
        }
    }
}
