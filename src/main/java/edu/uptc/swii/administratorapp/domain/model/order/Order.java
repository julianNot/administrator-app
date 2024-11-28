package edu.uptc.swii.administratorapp.domain.model.order;

import edu.uptc.swii.administratorapp.domain.model.customer.CustomerId;
import edu.uptc.swii.administratorapp.domain.exception.OrderValidationException;
import java.time.LocalDateTime;

public class Order {
    private final OrderId id;
    private final CustomerId customerId;
    private OrderStatus status;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Order(Builder builder) {
        this.id = builder.id;
        this.customerId = builder.customerId;
        this.status = builder.status;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        validate();
    }

    private void validate() {
        if (id == null) throw new OrderValidationException("Order ID is required");
        if (customerId == null) throw new OrderValidationException("Customer ID is required");
        if (status == null) throw new OrderValidationException("Status is required");
    }

    public void updateStatus(OrderStatus newStatus) {
        if (newStatus == null) {
            throw new OrderValidationException("New status cannot be null");
        }
        if (!status.canTransitionTo(newStatus)) {
            throw new OrderValidationException("Invalid status transition from " + status + " to " + newStatus);
        }
        this.status = newStatus;
        this.updatedAt = LocalDateTime.now();
    }

    public static Builder builder() {
        return new Builder();
    }

    // Getters
    public OrderId getId() { return id; }
    public CustomerId getCustomerId() { return customerId; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }

    public static class Builder {
        private OrderId id;
        private CustomerId customerId;
        private OrderStatus status;

        public Builder id(String id) {
            this.id = new OrderId(id);
            return this;
        }

        public Builder customerId(String customerId) {
            this.customerId = new CustomerId(customerId);
            return this;
        }

        public Builder status(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}